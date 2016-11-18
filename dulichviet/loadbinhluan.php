<?php
include_once("/connect.php");
if(isset($_POST['mand'])
){
$mand = $_POST['mand'];
$sql = "SELECT * FROM comment".
" WHERE mand = '$mand'";
$result = mysqli_query($conn, $sql);

while($row = mysqli_fetch_assoc($result)){
	$data[] = $row;
}
echo json_encode($data);
}





?>


