<?php
include_once("/connect.php");
if(isset($_POST['mand'])&&
isset($_POST['xem'])

){
	$mand = $_POST['mand'];
	$xem = $_POST['xem'];
	$tang = 1;
	$dem = $xem + $tang;
	//$chitiet = $_POST['chitiet'];
	//$hinhanh = $_POST['hinhanh'];
	//$ngaydang = $_POST['ngaydang'];
	//$iddanhmuc = $_POST['iddanhmuc'];
	//$thich = "null";
	//$xem = "";
	//$binhluan = "";
	
$sql = "UPDATE noidung SET xem = '$dem' WHERE mand = '$mand'";
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

