<?php

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "dulich";
//tao connection

 //$conn = mysql_connect('localhost', 'root', '');
 //   mysql_select_db('project',$conn);
   // mysql_set_charset('utf8',$conn); //chỉ cần thêm dòng này

$conn = mysqli_connect($servername, $username, $password, $dbname);
 $conn->set_charset('utf8');
//mysql_set_charset('utf8',$conn); 
	//kiem tra connection
	if(!$conn){
		die("Ket noi that bai" . mysqli_connect_errno);
	}
	 
?>