<?php
// 定义个人信息变量
$name = "1111";
$gender = "男";
$birthday = "2000年00月00日";
$hobbies = array("打游戏", "看电影", "旅游");
include "test.php";
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人介绍</title>
</head>
<body>
<!-- 使用表格组织个人信息 -->
<table border="10">
    <tr>
        <th>姓名：</th>
        <td><?php echo $name; ?></td>
    </tr>
    <tr>
        <th>性别：</th>
        <td><?php echo $gender; ?></td>
    </tr>
    <tr>
        <th>出生年月：</th>
        <td><?php echo $birthday; ?></td>
    </tr>
    <tr>
        <th>个人爱好：</th>
        <td>
            <ul>
                <?php foreach ($hobbies as $hobby): ?>
                    <li><?php echo $hobby; ?></li>
                <?php endforeach; ?>
            </ul>
        </td>
    </tr>
    <tr>
        <th>图片：</th>
        <td><img src="<?php echo $test; ?>"/></td>
    </tr>
</table>
</body>
    </html>
