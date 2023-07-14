<?php
// 指定上传文件的保存路径
$uploadDir = './uploads/';

// 处理文件上传操作
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_FILES['file'])) {
    $file = $_FILES['file'];

    if ($file['error'] === UPLOAD_ERR_OK) {
        // 将上传文件存储到指定目录中
        move_uploaded_file($file['tmp_name'], $uploadDir . $file['name']);
        // 显示上传成功提示信息
        echo '<p>文件上传成功！</p>';
    } else {
        echo '<p>文件上传失败，请重试。</p>';
    }
}

// 判断是否有已经上传的文件
if (isset($_GET['sort']) && file_exists($uploadDir . $_GET['file'])) {
    // 读取CSV文件内容并解析
    $csvData = array_map('str_getcsv', file($uploadDir . $_GET['file']));
    $headers = array_shift($csvData);

    // 获取排序参数并进行排序
    $sortColumn = intval($_GET['sort']);
    usort($csvData, function($a, $b) use ($sortColumn) {
        return $a[$sortColumn] <=> $b[$sortColumn];
    });

    // 输出表格内容
    echo '<table>';
    echo '<tr>' . implode('', array_map(function($h) { return "<th>{$h}</th>"; }, $headers)) . '</tr>';
    foreach ($csvData as $row) {
        echo '<tr>' . implode('', array_map(function($c) { return "<td>{$c}</td>"; }, $row)) . '</tr>';
    }
    echo '</table>';
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>文件上传和解析</title>
    <meta charset="UTF-8">
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            padding: 5px;
        }
    </style>
</head>
<body>
<!-- 显示上传文件的表单 -->
<form method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <button type="submit">上传文件</button>
</form>

<?php if (isset($_GET['file'])): ?>
    <!-- 显示排序链接 -->
    <p>按列排序：</p>
    <?php for ($i = 0; $i < count($headers); $i++): ?>
        <a href="?file=<?= $_GET['file'] ?>&sort=<?= $i ?>"><?= $headers[$i] ?></a>
    <?php endfor; ?>

    <?php if (file_exists($uploadDir . $_GET['file'])): ?>
        <!-- 显示CSV数据表格 -->
        <h2><?= $_GET['file'] ?></h2>
        <?php include_once($uploadDir . $_GET['file']); ?>
    <?php endif; ?>
<?php endif; ?>
</body>
</html>
