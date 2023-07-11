<?php
include_once "check.php";
$dsn = 'mysql:host=localhost;dbname=teaching;charset=utf8';
$username = 'root';
$password = '';
$articles = [];
try {
    // 创建数据库连接
    $pdo = new PDO($dsn, $username, $password);
    // 设置PDO错误模式为异常
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    $stmt = $pdo->query('SELECT username, user_id, title, content FROM articles');
    $articles = $stmt->fetchAll(PDO::FETCH_ASSOC);
} catch(PDOException $e) {
    echo "ERROR: " . $e->getMessage();
}
// 获取 GET 参数 id 的值
$id = isset($_GET['id']) ? intval($_GET['id']) : 0;

foreach ($articles as $article){
    if($article['user_id'] == $id){
        break;
    }
}
?>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>博客详情</title>
</head>
<body>
    <h1><?php echo $article['title'] ?></h1>
    <a href="article_list.php">博客列表</a>
    <p>作者ID：<?php echo $article['user_id'] ?></p>
    <p>作者：<?php echo $article['username'] ?></p>
    <hr>
    <p>正文：<br><?php echo $article['content'] ?></p>
</body>
</html>
