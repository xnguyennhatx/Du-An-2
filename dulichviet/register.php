<?php
include_once("connect.php");
if(isset($_POST['username'])&&
isset($_POST['email'])&&
isset($_POST['password'])

){
	$iduser = "NULL";
	$username = $_POST['username'];
	$email = $_POST['email'];
	$password = $_POST['password'];
	$avatar = "NULL";
	
	$query = "INSERT INTO users 
	VALUES($iduser, '$username', '$email', $password, $avatar)";
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