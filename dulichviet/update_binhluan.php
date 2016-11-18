<?php
include_once("/connect.php");
if(isset($_POST['mand'])&&
isset($_POST['thich'])
){
	$mand = $_POST['mand'];
	$thich = $_POST['thich'];


$sql = "UPDATE noidung SET thich = '$thich' WHERE mand = '$mand'";
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

