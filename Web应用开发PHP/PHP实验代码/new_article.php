<?php
include_once "check.php";

// 数据库连接参数，请根据实际情况填写
$dsn = 'mysql:host=localhost;dbname=teaching;charset=utf8';
$username = 'root';
$password = '';

try {
    // 创建数据库连接
    $pdo = new PDO($dsn, $username, $password);
    // 设置PDO错误模式为异常
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    // 处理表单提交
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        // 获取表单数据
        $title = $_POST["title"];
        $content = $_POST["content"];
        $username = $_SESSION['username'];

        // 插入文章数据
        $sql = "INSERT INTO articles (title, content, username) VALUES (:title, :content, :username)";
        $stmt = $pdo->prepare($sql);
        $stmt->bindParam(':title', $title);
        $stmt->bindParam(':content', $content);
        $stmt->bindParam(':username', $username);
        $stmt->execute();

        // 跳转至文章列表页面
//        header("Location: articles.php");
//        exit;
    }
} catch(PDOException $e) {
    echo "ERROR: " . $e->getMessage();
}
?>
<!DOCTYPE html>
<html lang="CN-zh">
<head>
    <meta charset="utf-8">
    <title>New Article</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<header>
    <h1>New Article</h1>
</header>
<nav>
    <ul>
        <li><a href="article_list.php">Articles</a></li>
        <li><a href="#">Logout</a></li>
    </ul>
</nav>
<main>
    <form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="post">
        <div>
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" required>
        </div>
        <div>
            <label for="content">Content:</label>
            <textarea id="content" name="content" rows="10" cols="50" required></textarea>
        </div>
        <button type="submit">Submit</button>
    </form>
</main>
</body>
</html>
