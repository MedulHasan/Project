<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "project";

// Create connection
 $conn = mysqli_connect($servername, $username, $password, $dbname);
// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

// sql to create table
$sql = "CREATE TABLE form (
  s_id int NOT NULL,
   sname varchar(200) NOT NULL,
   smoblie varchar(200) NOT NULL,
   sfmoblie varchar(200) NOT NULL,
   sfname varchar(200) NOT NULL,
   sfo varchar(200) NOT NULL,
   smname varchar(200) NOT NULL,
   smmoblie varchar(200) NOT NULL,
   smo varchar(200) NOT NULL,
   spi varchar(200) NOT NULL,
   ssex varchar(200) NOT NULL,
   sprdv varchar(200) NOT NULL,
   sprds varchar(200) NOT NULL,
   sprv varchar(200) NOT NULL,
   spdv varchar(200) NOT NULL,
   spds varchar(200) NOT NULL,
   spv varchar(200) NOT NULL,
   sbranch varchar(200) NOT NULL,
   sbroad varchar(200) NOT NULL,
   spy varchar(200) NOT NULL,
   sgpa varchar(200) NOT NULL,
   s12broad varchar(200) NOT NULL,
   s12py varchar(200) NOT NULL,
   s12gpa varchar(200) NOT NULL,
   primary key(s_id)
  
)" ;


if (mysqli_query($conn, $sql)) {
    echo "Table MyGuests created successfully";
} else {
    echo "Error creating table: " . mysqli_error($conn);
}

mysqli_close($conn);
?>