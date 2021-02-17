<?php

$conn=  mysqli_connect('localhost','root','','project');

if (isset($_POST['login'])) {
			
	$email=$_POST['email'];
	
	$pwd=$_POST['pass'];
	
		$i_query = "SELECT * FROM sign_up WHERE email ='$email' and  password ='$pwd'";
		$result=mysqli_query($conn,$i_query);
		$count = mysqli_num_rows($result);

		if($email=='admin@gmail.com' && $pwd==1234){
			echo "<script> alert('Login successful...')
	  window.location= '../admin_dashboard/admin_dashboard.php' </script>";
		}

		else{
			if ($count == 1) {
			echo "<script> alert('Login successful...')
	  window.location= '../select/select.php' </script>";
		}
		else{
			echo "<script> alert('Login unsuccessful...')
	  window.location= 'log.php' </script>";
		}
		}

		
	}
 ?>