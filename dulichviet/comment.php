<?php
include_once("connect.php");
if(isset($_POST['noidung'])&&
isset($_POST['username'])&&
isset($_POST['ngaybl'])&&
isset($_POST['mand'])

){
	$id = "NULL";
	$noidung = $_POST['noidung'];
	$username = $_POST['username'];
	$mand = $_POST['mand'];
	$ngaybl = $_POST['ngaybl'];
	
	
	
	$query = "INSERT INTO comment 
	VALUES($id, '$noidung', '$username','$mand', '$ngaybl')";
	$result = mysqli_query($conn, $query);
	if($result > 0){
		echo "thanhcong";
		exit;
	}else{
		echo "them that bai";
		exit;
	}
	}else{
	echo "error data";
	exit;
}
?>
                