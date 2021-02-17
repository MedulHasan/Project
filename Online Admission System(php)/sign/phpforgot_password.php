<?php

$conn=  mysqli_connect('localhost','root','','project');


  if (isset($_POST['cp'])) {
			$email = mysqli_real_escape_string($conn,$_POST['email']);
			$password = mysqli_real_escape_string($conn,$_POST['password']);

			if ($password == 0) {
				echo "<script> alert('Password Change unsuccessful...')
	  window.location= 'forgot_password.php' </script>";
			}
			
			else{
				mysqli_query($conn, "UPDATE sign_up SET password='$password' WHERE email='$email'");
				echo "<script> alert('Password Change successful...')
	  window.location= 'forgot_password.php' </script>";
			}
			
		}


 ?>