<?php

include_once("/connect.php"); 
$sql = "SELECT * FROM noidung ORDER BY mand DESC";

$result = mysqli_query($conn, $sql);
while($row = mysqli_fetch_assoc($result)){
	//$data[] = ($row);
	$data[] = $row;
}

echo json_encode($data);


?>
