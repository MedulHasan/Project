<?php

$mysqli=  mysqli_connect('localhost','root','','project');


  if(isset($_POST['btn'])){
	
	$user=$_POST['username'];
	$email=$_POST['email'];
	$pwd=$_POST['password'];
	
	
	$mysqli->query("INSERT INTO sign_up (name,email ,password) VALUES('$user','$email','$pwd')")or
	die($mysqli->error);

	  echo "<script> alert('Registation successful...')
	  window.location= 'signup.php' </script>";



  }

 ?>