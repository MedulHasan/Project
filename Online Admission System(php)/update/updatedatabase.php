<?php

$mysqli=  mysqli_connect('localhost','root','','project') or
      die(mysqli_error($mysqli));


  if(isset($_POST['frmupdate'])){
	$sid = $_POST['sid'];
	$sname = $_POST['sname'];
	$smoblie = $_POST['sphn'];
	$sfmoblie = $_POST['ufphn'];
	$sfname = $_POST['ufname'];
	$sfo = $_POST['ufocc'];
	$smname = $_POST['umname'];
	$smmoblie = $_POST['umphn'];
	$smo = $_POST['umocc'];
	$spi = $_POST['inc'];
    $ssex = $_POST['gen'];
	$sprdv = $_POST['div1'];
	$sprds = $_POST['dis1'];
	$sprv = $_POST['vill1'];
	$spdv = $_POST['div2'];
	$spds = $_POST['dis2'];
	$spv = $_POST['vill2'];
	$sbranch = $_POST['brnc'];
	$sbroad = $_POST['nob1'];
	$spy  = $_POST['yop1'];
	$sgpa = $_POST['tm2'];
	$s12broad  = $_POST['nob2'];
	$s12py = $_POST['yop2'];
	$s12gpa= $_POST['tm2'];
	
	
     $sql="update form set

    sname = '$sname',
	smoblie = '$smoblie',
	sfmoblie = '$sfmoblie',
	sfname = '$sfname ',
	sfo = '$sfo',
	smname = '$smname',
	smmoblie = '$smmoblie ',
	smo = '$smo',
	spi = '$spi',
    ssex = '$ssex',
	sprdv = '$sprdv ',
	sprds = '$sprds',
	sprv = '$sprv ',
	spdv = '$spdv ',
	spds = '$spds ',
	spv = '$spv',
	sbranch = '$sbranch ',
	sbroad = '$sbroad ',
	spy  = '$spy ',
	sgpa = '$sgpa',
	s12broad  = '$s12broad',
	s12py = '$s12py',
	s12gpa= '$s12gpa'
	WHERE s_id='$sid'
";


mysqli_query($mysqli, $sql);


        
        header('location:../update/update.php');
        echo "<script type='text/javascript'>alert('Details Uploaded !!');</script>";
        
        
    }
	
	
	
	?>