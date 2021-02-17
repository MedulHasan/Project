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