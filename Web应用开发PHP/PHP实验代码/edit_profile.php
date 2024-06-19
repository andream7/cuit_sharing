<?php
include_once "check.php";
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Update Profile</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<div class="update-profile-box">
    <h2>Update Profile</h2>
    <form method="POST" action="process_update_profile.php" enctype="multipart/form-data">
        <div class="textbox">
            <input type="text" placeholder="Username" name="username" value="<?php echo $_SESSION['username']; ?>" readonly>
        </div>
        <div class="textbox">
            <input type="text" placeholder="Full Name" name="fullname" value="<?php echo $row['fullname']; ?>" required>
        </div>
        <div class="textbox">
            <input type="text" placeholder="QQ Number" name="qq_number" value="<?php echo $row['qq_number']; ?>">
        </div>
        <div class="textbox">
            <input type="text" placeholder="Phone Number" name="phone_number" value="<?php echo $row['phone_number']; ?>" required>
        </div>
        <div class="textbox">
            <input type="email" placeholder="Email" name="email" value="<?php echo $row['email']; ?>" required>
        </div>
        <div class="textbox">
            <input type="file" name="avatar" accept="image/*">
        </div>
        <div class="textbox">
            <input type="password" placeholder="New Password" name="new_password">
        </div>
        <div class="textbox">
            <input type="password" placeholder="Confirm New Password" name="confirm_new_password">
        </div>
        <input class="btn" type="submit" name="submit" value="Update">
    </form>
</div>

</body>
</html>
