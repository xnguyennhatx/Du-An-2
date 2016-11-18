<?php
include_once("/connect.php");
if(isset($_POST['id'])){
	$maso = $_POST['id'];
	
	
$sql = "DELETE FROM sotay WHERE maso = '$maso'";
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