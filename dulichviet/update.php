<?php
include_once("/connect.php");
if(isset($_POST['mand'])&&
isset($_POST['username'])&&
isset($_POST['mota'])&&
isset($_POST['chitiet'])&&
isset($_POST['hinhanh'])&&
isset($_POST['ngaydang'])&&
isset($_POST['iddanhmuc'])
){
	$mand = $_POST['mand'];
	$username = $_POST['username'];
	$mota = $_POST['mota'];
	$chitiet = $_POST['chitiet'];
	$hinhanh = $_POST['hinhanh'];
	$ngaydang = $_POST['ngaydang'];
	$iddanhmuc = $_POST['iddanhmuc'];
	$thich = "null";
	$xem = "";
	$binhluan = "";
	
$sql = "UPDATE noidung SET username = '$username',mota = '$mota',chitiet = '$chitiet',hinhanh = '$hinhanh',ngaydang = '$ngaydang',iddanhmuc = '$iddanhmuc',thich = '$thich',xem = '$xem',binhluan = '$binhluan' WHERE mand = '$mand'";
$result = mysqli_query($conn, $sql);
if($result > 0){
	echo thanhcong;
	exit;
}else{
	echo failed;
	exit;
}

}else{
echo "khong co du lieu";
}
?>

