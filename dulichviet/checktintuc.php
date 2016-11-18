<?php
include_once("/connect.php");
if(isset($_POST['name'])
){
	$username = $_POST['name'];

	
$sql = "SELECT * FROM noidung".
" WHERE username = '$username'";
$result = mysqli_query($conn, $sql);

while($row = mysqli_fetch_assoc($result)){
	$data[] = $row;
}
echo json_encode($data);
}
?>