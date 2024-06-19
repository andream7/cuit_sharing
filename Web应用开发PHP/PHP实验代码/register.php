<?php
session_start();

if(isset($_POST['submit'])) {

    $username = $_POST['username'];
    $password = $_POST['password'];
    $confirm_password = $_POST['confirm_password'];

    // 判断用户名是否已被占用
    $servername = "localhost";
    $dbusername = "root";
    $dbpassword = "";
    $dbname = "teaching";

    $conn = new mysqli($servername, $dbusername, $dbpassword, $dbname);
    if($conn->connect_error) {
        die("连接失败：" . $conn->connect_error);
    }

    $sql = "SELECT * FROM users WHERE username='$username'";
    $result = $conn->query($sql);

    if($result->num_rows > 0) {
        echo "<script>alert('该用户名已被占用！');window.location.href='register.php';</script>";
    } else {
        // 密码加密（可根据具体要求自行选择加密方式）
        $encrypted_password = md5($password);

        // 插入数据到用户表中
        $sql = "INSERT INTO users (username, password) VALUES ('$username', '$encrypted_password')";
        if($conn->query($sql)) {
            $_SESSION['username'] = $username;
            header("Location: welcome.php");
        } else {
            echo "<script>alert('注册失败！');window.location.href='register.php';</script>";
        }
    }
    exit;
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Register</title>
  <meta charset="utf-8">
  <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<div class="register-box">
  <h2>Register Here</h2>
  <form method="POST" action="register.php">
    <div class="textbox">
      <input type="text" placeholder="Username" name="username" required>
    </div>
    <div class="textbox">
      <input type="password" placeholder="Password" name="password" required>
    </div>
    <div class="textbox">
      <input type="password" placeholder="Confirm Password" name="confirm_password" required>
    </div>
    <input class="btn" type="submit" name="submit" value="Register">
  </form>
</div>

</body>
</html>

