<?php
$path = "uploads/"; // 指定目录路径
$files = glob($path . '*'); // 获取目录下的所有文件
usort($files, function($a, $b) { // 按照时间排序
    return filemtime($a) < filemtime($b);
});
$filename = reset($files); // 获取最新上传的文件

$data = array(); //定义数组存储csv中的信息

if (file_exists($filename)) {
    $fp = fopen($filename, "r");
    $i = 0;
    if ($fp) {
        while (($line = fgetcsv($fp)) !== false) {
            $row = explode("\t", $line[0]);
            for ($j = 0; $j < count($row); $j++){
                $data[$j][$i] = $row[$j];
            }
            $i++;
        }
        fclose($fp);
    }
    // 根据Get参数判断排序哪一列数据
    for ($i = 0; $i < count($data); $i++){
        if(isset($_GET["sort"]) && $_GET["sort"] == $i){
            if($_GET["order"] == 1){
                sort($data[$i]);
            }else{
                rsort($data[$i]);
            }
            break;
        }
    }
    $result = array();
    foreach ($data as $key1 => $subarr) { //遍历原始数组的第一层
        foreach ($subarr as $key2 => $value) { //遍历原始数组的第二层
            $result[$key2][$key1] = $value; //将每个元素的位置横纵反转并存储到新数组
        }
    }
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>文件上传和解析</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            padding: 5px;
        }
    </style>
</head>
<body>
<form action="upload.php" method="post" enctype="multipart/form-data" >
    <label for="csvfile">选择CSV文件：</label>
    <input type="file" name="csvfile" id="csvfile">
    <input type="submit" value="上传">
</form>

<table border="5">
    <thead>
    <tr>
        <?php
            for($i = 0; $i < count($result[0]); $i++) {
                echo "<th>";
                echo "<a href='?sort=$i&order=1'>升序</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
                echo "<a href='?sort=$i&order=0'>降序</a>";
                echo "</th>";
            }
        ?>
    </tr>
    </thead>
    <tbody>
        <?php
            foreach ($result as $row) {
                echo "<tr>";
                foreach ($row as $col) {
                    echo "<td>$col</td>";
                }
                echo "</tr>";
            }
        ?>
    </tbody>
</table>
</body>
</html>
