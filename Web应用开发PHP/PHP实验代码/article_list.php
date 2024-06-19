<?php
    include_once "check.php";

    // 数据库连接参数，请根据实际情况填写
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
    // 获取留言总数
    $count = count($articles);
    // 每页显示 5 条留言
    $page_size = 5;
    // 计算总页数
    $total_page = ceil($count / $page_size);
    // 根据 GET 参数计算当前页数
    $page_num = isset($_GET['page']) ? intval($_GET['page']) : 1;

    // 如果当前页数小于 1，则将其设置为 1
    $page_num = max($page_num, 1);

    // 如果当前页数大于总页数，则将其设置为总页数
    $page_num = min($page_num, $total_page);

    // 计算偏移量
    $offset = ($page_num - 1) * $page_size;
    $messages = array();

    for ($i = $offset; $i < $offset + $page_size && $i < $count; $i++) {
        $message = $articles[$i];
        $messages[] = $message;
    }
?>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>留言列表</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>
<body>
<a href="new_article.php">发表博客</a>
<table>
    <tr>
        <th>作者</th>
        <th>作者ID</th>
        <th>主题</th>
        <th>内容</th>
        <th>操作</th>
    </tr>
    <?php foreach ($messages as $article) : ?>
        <tr>
            <td><?php echo $article['username'] ?></td>
            <td><?php echo $article['user_id'] ?></td>
            <td><?php echo substr($article['title'],0,15) ?></td>
            <td><?php echo substr($article['content'],0,25) ?></td>
            <td>
                <a href="delete.php?id=<?php echo $article['user_id'] ?>">删除</a>
                <a href="view_article.php?id=<?php echo $article['user_id'] ?>">查看</a>
            </td>
        </tr>
    <?php endforeach ?>
</table>
<br>
<?php if ($page_num > 1): ?>
    <a href="?page=<?php echo $page_num - 1 ?>">上一页</a>
<?php endif ?>
<?php if ($page_num < $total_page): ?>
    <a href="?page=<?php echo $page_num + 1 ?>">下一页</a>
<?php endif ?>
</body>
</html>
