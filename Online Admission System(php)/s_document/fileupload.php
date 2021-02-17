<?php
session_start();
$sp=mysqli_connect("localhost","root","","project");
         if($sp->connect_errno){
                echo "Error <br/>".$sp->error;
}


if(isset($_POST['fpicup'])){

$img=$_FILES['fpic']['name'];
$img1=$_FILES['ftndoc']['name'];
$img2=$_FILES['ftcdoc']['name'];
$img3=$_FILES['fdmdoc']['name'];
$img4=$_FILES['fdcdoc']['name'];
$img5=$_FILES['fide']['name'];
$img6=$_FILES['fsig']['name'];


$query="insert into `t_userdoc` (s_pic,s_tenmarkpic,s_tencerpic,
    s_twdmarkpic, s_twdcerpic, s_idprfpic, s_sigpic) values 
    ('$img','$img1','$img2','$img3','$img4','$img5','$img6')";
        if($sp->query($query)){
          if($query==true){
     echo "<script> alert('file uploded...')
      window.location= '../s_dashboard/s_dashboard.php' </script>"; 
      }  
    }
}


 ?>