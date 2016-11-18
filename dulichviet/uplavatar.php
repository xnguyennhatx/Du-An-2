<?php
	if(isset($_POST['i'])&&
		isset($_POST['r'])
	){
		$image = $_POST['i'];
		$r = $_POST['r'];
		images($_POST['i'], $_POST['r']);
		exit;
	}else{
		echo "rong";
		
		exit;
	}
	function images($image, $r){
		$now = DateTime::createFromFormat('U.u', microtime(true));
		$id = $now->format('Ymd');
		$upload_folder = "images";
		$path = "$upload_folder/$id$r.jpeg";
		if(file_put_contents($path, base64_decode($image))!=false){
			echo "thanhcong";
			exit;
		}
		else{
					echo "thatbai";
					exit;
		}
	}
	


?>