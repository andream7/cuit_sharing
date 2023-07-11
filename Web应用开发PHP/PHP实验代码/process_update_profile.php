<?php
session_start();

if(isset($_POST['submit'])) {

    $username = $_SESSION['username'];
    $fullname = $_POST['fullname'];
    $qq_number = $_POST['qq_number'];
    $phone_number = $_POST['phone_number'];
    $email = $_POST['email'];
    $new_password = $_POST['new_password'];
    $confirm_new_password = $_POST['confirm_new_password'];

    $servername = "localhost";
    $dbusername = "root";
    $dbpassword = "";
    $dbname = "teaching";

    $conn = new mysqli($servername, $dbusername, $dbpassword, $dbname);
    if($conn->connect_error) {
        die("连接失败：" . $conn->connect_error);
    }

    // 处理头像上传
//    if(!empty($_FILES['avatar']['name'])){
//        $upload_name=$_FILES['avatar']['name'];
//        $avatar_path = "uploads/" . $upload_name;
//        $type=substr($upload_name,strrpos($upload_name,'.')+1);
//        if($type == "jpg" || $type == "png" || $type == "gif"){
//            $address=$_POST['address'].".".$type;
//            if (move_uploaded_file($_FILES['avatar']['tmp_name'],"uploads/".$address)) {
//                $sql = "UPDATE users SET avatar='$avatar_path' WHERE username='$username'";
//                $conn->query($sql);
//            }else {
//                echo "<script>alert('头像上传失败！');window.location.href='edit_profile.php';</script>";
//                exit;
//        }
//        }
//    }

    if($_FILES['avatar']['error'] == 0) {
        $avatar_filename = $_FILES['avatar']['name'];
        $avatar_tmpname = $_FILES['avatar']['tmp_name'];
        $avatar_type = $_FILES['avatar']['type'];
        $avatar_size = $_FILES['avatar']['size'];

        $avatar_path = "uploads/" . $avatar_filename;
        if($avatar_type == "image/jpg" || $avatar_type == "image/png" || $avatar_type == "image/gif"){
            if(move_uploaded_file($avatar_tmpname, $avatar_path)) {
                $sql = "UPDATE users SET avatar='$avatar_path' WHERE username='$username'";
                $conn->query($sql);
            } else {
                echo "<script>alert('头像上传失败！');window.location.href='edit_profile.php';</script>";
                exit;
            }
        }
    }


    // 处理密码修改
    if($new_password != "") {
        $encrypted_new_password = md5($new_password);
        $encrypted_confirm_new_password = md5($confirm_new_password);

        if($encrypted_new_password != $encrypted_confirm_new_password) {
            echo "<script>alert('两次输入的新密码不一致！');window.location.href='edit_profile.php';</script>";
            exit;
        } else {
            $sql = "UPDATE users SET password='$encrypted_new_password' WHERE username='$username'";
            $conn->query($sql);
        }
    }

    // 更新用户信息
    $sql = "UPDATE users SET fullname='$fullname', qq_number='$qq_number', phone_number='$phone_number', email='$email' WHERE username='$username'";
    if($conn->query($sql)) {
        echo "<script>alert('个人信息修改成功！');window.location.href='edit_profile.php';</script>";
        exit;
    } else {
        echo "<script>alert('个人信息修改失败！');window.location.href='edit_profile.php';</script>";
        exit;
    }

}
?>
