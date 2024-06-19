<?php
// 获取 GET 参数 id 的值
$id = isset($_GET['id']) ? intval($_GET['id']) : 0;

// 根据留言 ID 构造留言文件名
$filename = sprintf('messages/%d.json', $id);

// 如果留言文件不存在，则返回 404 页面
if (!file_exists($filename)) {
    echo $filename;
    header('HTTP/1.1 404 Not Found');
    exit('Page Not Found');
}

// 读取留言文件内容并解析成数组
$content = file_get_contents($filename);
$message = json_decode($content, true);
$image_path = "uploads/" . $message['author_id'] . "_" . $message['tail'];
?>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>留言详情</title>
</head>
<body>
    <h1><?php echo $message['title'] ?></h1>
    <a href="upload_comments.html">点击留言</a>
    <p>作者ID：<?php echo $message['author_id'] ?></p>
    <p>时间：<?php echo $message['timestamp'] ?></p>
    <img src="<?php echo $image_path ?>" alt="testimage">
    <hr>
    <p>正文：<br><?php echo $message['content'] ?></p>
</body>
</html>
