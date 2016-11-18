<?php
include_once("/connect.php");
if(isset($_POST['email'])&&
isset($_POST['password'])
){
	$email = $_POST['email'];
	$password = $_POST['password'];

	
$sql = "UPDATE users SET password = '$password' WHERE email = '$email'";
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

