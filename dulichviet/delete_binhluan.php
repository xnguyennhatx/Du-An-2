<?php
include_once("/connect.php");
if(isset($_POST['macom'])
	&& isset($_POST['username'])
){
	$macom = $_POST['macom'];
	$username = $_POST['username'];

	
	$sql = "DELETE FROM comment".
" WHERE macom = '$macom' AND username = '$username'";
//$sql = "DELETE FROM comment WHERE macom = '$macom' AND username = '$username'";
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