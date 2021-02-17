
<!DOCTYPE html>
<html>
<head>
<title>Creative Colorlib SignUp Form</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Custom Theme files -->
<link href="scss.css" rel="stylesheet" type="text/css" media="all" />
<!-- //Custom Theme files -->
<!-- web font -->
<link href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i" rel="stylesheet">
<!-- //web font -->
</head>
<body>
	<!-- main -->
	<div class="main-w3layouts wrapper">
		<h1>Creative</h1>
		<div class="main-agileinfo">
			<div class="agileits-top">
				<form id="form" action="update.php" method="post">
					
					<input class="text email" type="email" name="email" id="email" placeholder="Enter Your Email" required="">
					<input class="text email" type="text" name="id" id="id" placeholder="Enter your id" required="">
					
					<input type="submit" name="btn1" value="FORM">
				</form>
			</div>
		</div>
		<!-- copyright -->
		<div class="colorlibcopy-agile">
			<p>© 2019 Raptors Signup Form. All rights reserved | Design by <a href="">Raptors</a></p>
		</div>

	<script>
		$("#form").validate({
			rules: {
				email: {
                    required: true,
                    email: true
                },
                password: {
                    required: true,
                    minlength: 8,
                    maxlength: 12
                },
                cpassword: {
       				required: true,
                    equalTo: "#password"
                }
			}
		});
	</script>

</body>
</html>