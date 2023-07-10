<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<div class="login-box">
    <h2>Login Here</h2>
    <form method="POST" action="login.php">
        <div class="textbox">
            <input type="text" placeholder="Username" name="username" required>
        </div>
        <div class="textbox">
            <input type="password" placeholder="Password" name="password" required>
        </div>
        <input class="btn" type="submit" name="submit" value="Sign In">
    </form>
    <a href="register.php" style="align-content: center">注册</a>
</div>

</body>
</html>
<?php
session_start();

if(isset($_POST['submit'])) {

    $username = $_POST['username'];
    $password = $_POST['password'];
    // 密码加密（可根据具体要求自行选择加密方式）
    $encrypted_password = md5($password);

    // 用户名密码验证，需根据具体的用户表和加密方式进行修改
    $servername = "localhost";
    $dbusername = "root";
    $dbpassword = "";
    $dbname = "teaching";

    $conn = new mysqli($servername, $dbusername, $dbpassword, $dbname);
    if($conn->connect_error) {
        die("连接失败：" . $conn->connect_error);
    }

    $sql = "SELECT * FROM users WHERE username='$username' AND password='$encrypted_password'";
    $result = $conn->query($sql);

    if($result->num_rows > 0) {
        // 登录成功
        session_start();
        $_SESSION['username'] = $username;
        header("Location: welcome.php");
    } else {
        echo "<script>alert('用户名或密码错误！');window.location.href='login.php';</script>";
    }
    exit;
}
