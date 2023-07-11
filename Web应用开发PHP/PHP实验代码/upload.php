<?php
if ($_FILES["csvfile"]["error"] == UPLOAD_ERR_OK) {
    $filename = $_FILES["csvfile"]["name"];
    $ext = pathinfo($filename, PATHINFO_EXTENSION);

    if ($ext == "csv") {
        move_uploaded_file($_FILES["csvfile"]["tmp_name"], "uploads/" . $filename);
        header('Location: /phptest/file.php');
        exit;
//        echo "file upload succeed";
    } else {
        echo "error";
    }
}

