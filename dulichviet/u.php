
<?php
include_once("/connect.php");
if(isset($_POST['username'])
){
	$username = $_POST['username'];
	
$sql = "SELECT * FROM users".
" WHERE username = '$username'";
$result = mysqli_query($conn, $sql);

while($row = mysqli_fetch_assoc($result)){
	$data[] = $row;
}
echo json_encode($data);
}
?>