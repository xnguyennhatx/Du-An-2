<?php
include_once("connect.php");
if(isset($_POST['username'])&&
isset($_POST['diadiem'])&&
isset($_POST['noidung'])&&
isset($_POST['ngaytao'])

){
	$id = "NULL";
	$username = $_POST['username'];
	$diadiem = $_POST['diadiem'];
	$noidung = $_POST['noidung'];
	$ngaytao = $_POST['ngaytao'];
	
	$query = "INSERT INTO sotay 
	VALUES($id, '$diadiem', '$noidung','$username', '$ngaytao')";
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