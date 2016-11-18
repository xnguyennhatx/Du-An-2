<?php
include_once("/connect.php");
if(isset($_POST['username'])&&
isset($_POST['hinhanh'])

){
	$username = $_POST['username'];
	$hinhanh = $_POST['hinhanh'];

	
$sql = "UPDATE users SET avatar = '$hinhanh' WHERE username = '$username'";
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

