<?php
include_once "check.php";
$dsn = 'mysql:host=localhost;dbname=teaching;charset=utf8';
$username = 'root';
$password = '';
$articles = [];
// 获取 GET 参数 id 的值
$id = isset($_GET['id']) ? intval($_GET['id']) : 0;
try {
    // 创建数据库连接
    $pdo = new PDO($dsn, $username, $password);
    // 设置PDO错误模式为异常
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    $stmt = $pdo->query('SELECT username, user_id, title, content FROM articles');
    $articles = $stmt->fetchAll(PDO::FETCH_ASSOC);

    foreach ($articles as $article){
        if($article['user_id'] == $id){
            $stmt = $pdo->prepare('DELETE FROM articles where user_id = :id');
            // 绑定参数
            $stmt->bindParam(':id', $id, PDO::PARAM_INT);
            // 执行 SQL 语句
            $stmt->execute();
            break;
        }
    }
    header("Location: article_list.php");
} catch(PDOException $e) {
    echo "ERROR: " . $e->getMessage();
}
?>
