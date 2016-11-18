<?php
include_once("/connect.php");
if(isset($_POST['username'])&&
isset($_POST['password'])
){
	$username = $_POST['username'];
	$password = $_POST['password'];
	
$sql = "SELECT * FROM users".
" WHERE username = '$username' AND password = '$password'";
$result = mysqli_query($conn, $sql);
if($result->num_rows > 0){
	echo thanhcong;
}else{
	echo failed;
}
while($row = mysqli_fetch_assoc($result)){
	$data[] = $row;
}
echo json_encode($data);
}
?>