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
	
    
	//echo $time;
		//$r = "12222";
		
		$now = DateTime::createFromFormat('U.u', microtime(true));
		$id = $now->format('Ymd');
		//$idi = $id.$r;
		//$id = $now->format('YmdHisu');
		//HHmmss yyyMMdd
		$upload_folder = "images";
		$path = "$upload_folder/$id$r.jpeg";
	//	$path = "$upload_folder/".$image;
		
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