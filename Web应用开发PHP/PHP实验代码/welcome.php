<?php
include_once "check.php";
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Welcome</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h2>Welcome, <?php echo $_SESSION['username']; ?>!</h2>
    <a href="edit_profile.php">Edit Profile</a>
    <div class="update-profile-box" style="font-size: larger; color: #4CAF50; font-weight: bold">
        <div class="textbox">
            username:
            <input type="text" placeholder="Username" name="username" value="<?php echo $_SESSION['username']; ?>" readonly>
        </div>
        <div class="textbox">
            fullname:
            <input type="text" placeholder="Full Name" name="fullname" value="<?php echo $row['fullname']; ?>" readonly>
        </div>
        <div class="textbox">
            qq_number:
            <input type="text" placeholder="QQ Number" name="qq_number" value="<?php echo $row['qq_number']; ?>" readonly>
        </div>
        <div class="textbox">
            phone_number:
            <input type="text" placeholder="Phone Number" name="phone_number" value="<?php echo $row['phone_number']; ?>" readonly>
        </div>
        <div class="textbox">
            email:
            <input type="email" placeholder="Email" name="email" value="<?php echo $row['email']; ?>" readonly>
        </div>
        <div class="textbox">
            avatar:
            <img src="<?php echo $row['avatar']?>">
        </div>
    </div>
</body>
</html>

