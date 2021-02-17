<?php

$mysqli=  mysqli_connect('localhost','root','','project') or
      die(mysqli_error($mysqli));


  if(isset($_POST['frmnext'])){
  	$s_id = $_POST['sid'];
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
	
	
	$mysqli->query("INSERT INTO form (s_id,sname,smoblie,sfmoblie,sfname,sfo,smname,smmoblie,smo,spi,
                   ssex ,sprdv,sprds,sprv,spdv,spds,spv,sbranch,sbroad,spy ,sgpa,s12broad ,s12py,s12gpa) 
				   VALUES($s_id,'$sname','$smoblie','$sfmoblie','$sfname','$sfo','$smname','$smmoblie','$smo','$spi',
                   '$ssex' ,'$sprdv','$sprds','$sprv','$spdv','$spds','$spv','$sbranch','$sbroad','$spy' ,'$sgpa','$s12broad' ,'$s12py','$s12gpa')")or
	die($mysqli->error);
	  
	  header("location: ../s_document/documents.php");

  }
  
  ?>