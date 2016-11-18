<?php
include_once("connect.php");
if(isset($_POST['username'])&&
isset($_POST['mota'])&&
isset($_POST['chitiet'])&&
isset($_POST['hinhanh'])&&
isset($_POST['ngaydang'])&&
isset($_POST['iddanhmuc'])&&
isset($_POST['binhluan'])&&
isset($_POST['lat'])&&
isset($_POST['lang'])
){
	$id = "NULL";
	$username = $_POST['username'];
	$mota = $_POST['mota'];
	$chitiet = $_POST['chitiet'];
	$hinhanh = $_POST['hinhanh'];
	$ngaydang = $_POST['ngaydang'];
	$iddanhmuc = $_POST['iddanhmuc'];
	$binhluan = $_POST['binhluan'];
	$thich = "null";
	$xem = "";
	$Lat = $_POST['lat'];
	$Lang = $_POST['lang'];
	
	
	$query = "INSERT INTO noidung 
	VALUES($id, '$username', '$mota', '$chitiet', '$hinhanh', '$ngaydang', '$thich', '$xem', '$binhluan','$iddanhmuc', '$Lat', '$Lang')";
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