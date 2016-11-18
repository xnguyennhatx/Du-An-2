<?php
include_once("/connect.php");
if(isset($_POST['id'])){
	$id = $_POST['id'];
	
	
$sql = "DELETE FROM noidung WHERE mand = '$id'";
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