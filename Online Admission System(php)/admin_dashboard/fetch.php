

<?php
$connect = mysqli_connect("localhost", "root", "", "project");
$output = '';
if(isset($_POST["query"]))
{
	$search = mysqli_real_escape_string($connect, $_POST["query"]);
	$query = "
	SELECT * FROM form 
	WHERE s_id LIKE '%".$search."%'
	
	
	";
}
else
{
	$query = "
	SELECT * FROM form ORDER BY s_id";
}
$result = mysqli_query($connect, $query);
if(mysqli_num_rows($result) > 0)
{
	
	
                echo '<table class="table table-striped" id="tblData">';
                echo "<thead>";
                echo "<tr>";
                echo "<th>ID</th>";
                echo "<th>NAME</th>";
				echo "<th>CONTACT NO.</th>";
                echo "<th>Branch</th>";
                echo "<th>Gender</th>";
                echo "<th>Confirm</th>";
                echo "<tr>";
                echo "</thead>";
                echo "<tbody>";
		while($ar = mysqli_fetch_array($result))
                {
               echo "<tr>";
              
               echo "<td><a href='../view/view.php?id=".$ar['s_id']."'>" . $ar['s_id'] . "</a></td>";
                echo "<td>" . $ar['sname'] . "</td>";
                echo "<td>" . $ar['smoblie'] . "</td>";
                echo "<td>" . $ar['sbranch'] . "</td>";
                echo "<td>" . $ar['ssex'] . "</td>";
                echo "<td>"?><div class="container">
                    <button type="button" name="add" class="btn btn-success">Add</button>
                    <button type="button" name="del" class="btn btn-danger">Delete</button> 
                </div><?php "</td>";
                
             
                 echo "</tr>";
               
		}

                echo "</tbody>";
                echo "</table>";
}
else
{
	echo 'Data Not Found';
} 
?>


<?php 

    if(isset($_POST['add'])){
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
    
    
    $mysqli->query("INSERT INTO add_std (s_id,sname,smoblie,sfmoblie,sfname,sfo,smname,smmoblie,smo,spi,
                   ssex ,sprdv,sprds,sprv,spdv,spds,spv,sbranch,sbroad,spy ,sgpa,s12broad ,s12py,s12gpa) 
                   VALUES($s_id,'$sname','$smoblie','$sfmoblie','$sfname','$sfo','$smname','$smmoblie','$smo','$spi',
                   '$ssex' ,'$sprdv','$sprds','$sprv','$spdv','$spds','$spv','$sbranch','$sbroad','$spy' ,'$sgpa','$s12broad' ,'$s12py','$s12gpa')")or
    die($mysqli->error);
      
      header("location: ../s_document/documents.php");

  }
    }

 ?>