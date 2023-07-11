<?php
    if(isset($_POST['author_id']) && $_POST['author_id']){
        // 接收上传来的图片 命名为上传者的id
        if($_FILES['image']['error'] == UPLOAD_ERR_OK) {
            $ext = pathinfo($_FILES['image']['name'], PATHINFO_EXTENSION);
            move_uploaded_file($_FILES["image"]["tmp_name"], "uploads/" . $_POST['author_id'] . "_" . $_SERVER['REQUEST_TIME'] . "." . $ext);

            $data = array(
                "author_id" => $_POST['author_id'],
                "title" => $_POST['title'],
                "content" => $_POST['content'],
                "tail" => $_SERVER['REQUEST_TIME'] . "." . $ext,
                "timestamp" =>  date('Y-m-d H:i:s', $_SERVER['REQUEST_TIME'])
            );

            $json_data = json_encode($data);

            //将JSON格式字符串写入文件
//            file_put_contents('messages/' . $_POST['author_id']. "_" . $_SERVER['REQUEST_TIME'] . '.json', $json_data);
            file_put_contents('messages/' . $_POST['author_id'] . '.json', $json_data);
        }
    }
    // 获取留言总数
    $count = count(glob('messages/*.json'));

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

    // 获取当前页的留言数据
    $messages = array();
    $message_files = glob('messages/*.json');
    for ($i = $offset; $i < $offset + $page_size && $i < $count; $i++) {
        $content = file_get_contents($message_files[$i]);
        $message = json_decode($content, true);
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
<a href="upload_comments.html">点击留言</a>
<table>
    <tr>
        <th>作者ID</th>
        <th>主题</th>
        <th>内容</th>
        <th>时间</th>
        <th>操作</th>
    </tr>
    <?php foreach ($messages as $message): ?>
        <tr>
            <td><?php echo $message['author_id'] ?></td>
            <td><?php echo $message['title'] ?></td>
            <td><?php echo $message['content'] ?></td>
            <td><?php echo $message['timestamp'] ?></td>
            <td><a href="view_message.php?id=<?php echo $message['author_id'] ?>">查看</a></td>
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
