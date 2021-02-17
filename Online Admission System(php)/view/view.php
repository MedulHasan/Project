 <?php

        $mysqli=  mysqli_connect("localhost","root","","project") or die (mysqli_error($mysqli));
        
        if (isset($_POST['btn1'])) {
      $email=$_POST['email'];
        $id   =$_POST['id'];
        
        $result1=$mysqli->query("SELECT * FROM sign_up WHERE email='$email' AND $id='s_id'")or die($mysqli->error);
      }
         ?>

        


<?php
        $mysqli=  mysqli_connect("localhost","root","","project") or die (mysqli_error($mysqli));
        $result=$mysqli->query("SELECT * FROM form WHERE s_id='$id' ")or die($mysqli->error);





       ?>




<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta http-equiv="X-UA-Compatible" content="ie=edge" />
  <title>Student DashBoard</title>

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous" />
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
    crossorigin="anonymous">
  <link rel="stylesheet" href="./Style.css" />
  <link rel="stylesheet" href="./mobile-style.css">
</head>

<body>


  <header>
    <div class="container-fluid p-0">
      <nav class="navbar navbar-expand-lg">
        <a class="navbar-brand" href="#">
          <i class="fas fa-book-reader fa-2x mx-3"></i>Student DashBoard</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
          aria-label="Toggle navigation">
          <i class="fas fa-align-right text-light"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <div class="mr-auto"></div>
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link" href="http://localhost/project/p/s_dashboard/s_dashboard.php">Application Form
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item active_home">
              <a class="nav-link" href="#">View Form</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="http://localhost/project/p/update/select_update.php">Edit Form</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="http://localhost/project/p/Home/src/">Log Out</a>
            </li>
          </ul>
        </div>
      </nav>
    </div>
  </header>





<main>
        <form id="viform" action="viewform.php" method="post">
            <div class="container-fluid">    
                <div class="row">
                  
                 </div>    
             </div><br>
                <div  class="container-fluid">  
                
                
                
                </div>
         
  <div class="container-fluid">
                            <div class="row">
                               <div class="col-sm-12">
      <center>  <table class="table table-bordered" style="font-family: Verdana">
                
                <tr>
                 <td style="width:20%;"><img src="1.jpg" width="100%"> </td>
                 <td style="width:50%;"><center><font style="font-family:Arial Black; font-size:20px;">
                    STAMFORD UNIVERSITY BANGLADESH</font></center>
                
                <center><font style="font-family:Verdana; font-size:18px;">
                    Phone : (0674)2492496, Fax : (0674)2490480
                    </font></center>
                
                <br>
                <br>

                       
                 </tr>       
                 <?php
          while($row = $result->fetch_assoc()):?>
                 <tr>
                 <td style="width:4%;"> <font style="font-family: Verdana;">Name : </font> </td>
                    <td style="width:8%;" colspan="3"> <?php echo $row['sname'];?> </td>
                 </tr>
                 
                 
                <tr>
                    <td> <font style="font-family: Verdana;">ID : </font> </td>
                    <td colspan="3"> <?php echo $row['s_id']; ?> </td>
                </tr>
                   
                  <tr>
                    <td > <font style="font-family: Verdana;">Student's Mobile No.</font>  </td>
                      <td style="width:8%;" colspan="3"> <?php echo $row['smoblie'];?> </td>
                    
                  </tr>
                
                  <tr>
                    <td><font style="font-family: Verdana;"> Father's Name</font></td>
                    <td  colspan="3"><?php echo $row['sfname'] ?> </td>
                   </tr>
                 
                  <tr>
                    <td> <font style="font-family: Verdana;">Father's Occupation</font></td>
                    <td> <?php echo $row['sfo'] ?></td>
                    <td><font style="font-family: Verdana;"> Mobile No.</font></td>
                    <td> <?php echo $row['sfmoblie'] ?> </td>
                  </tr>
                
                <tr>
                    <td> <font style="font-family: Verdana;">Mother's Name</font> </td>
                    <td colspan="3"> <?php echo $row['smname'] ?></td>
                </tr>
                
                <tr>
                    <td> <font style="font-family: Verdana;">Mother's Occupation</font></td>
                    <td> <?php echo $row['smo'] ?> </td>
                     <td> <font style="font-family: Verdana;">Mobile No.</font></td>
                    <td> <?php echo $row['smmoblie'] ?></td>
                </tr>
                
                <tr>
                    <td><font style="font-family: Verdana;"> Income of Parents </font>
                     <td  colspan="3"><?php echo $row['spi'] ?></td>
                </tr>
                
                <tr>
                    <td> <font style="font-family: Verdana;">Sex </font>
                    <td colspan="3"><?php echo $row['ssex'] ?></td>       
                    
                </tr>
                
                <tr>
                    <td><font style="font-family: Verdana;"> Present Address</font>
                          <td colspan="3"><?php echo 'Address :' ?><br>
                          <?php echo 'Division :'. $row['sprdv'] ?><br>
                          <?php echo 'District :'. $row['sprds'] ?><br>
                          <?php echo 'Village :'. $row['sprv'] ?><br>
                </td>
                
                </tr>
        <tr>
                    <td> <font style="font-family: Verdana;">Permanent Address</font>
                    <td colspan="3"><?php  echo 'Address :'  ?><br>
                         <?php echo 'Division :'. $row['spdv'] ?><br>
                          <?php echo 'District :'. $row['spds'] ?><br>
                          <?php echo 'Village :'. $row['spv'] ?><br>
                </td>
                </tr>   
               
               
               
               <tr>
                    <td><font style="font-family: Verdana;">Choice of Branch</font></td>
                    <td colspan="3"><?php echo $row['sbranch'] ?>
                     </td>
               </tr>
               
                
                
                
                
                
               <tr>
                   <td><font style="font-family: Verdana;">Academic Qualification</font></td>
                   <td colspan="3">
                       <table class="table table-hover">
                           <thead>
                               <tr>
                                    <th><font style="font-family: Verdana;font-size: small">Exam</font> <br><font style="font-family: Verdana; font-size: small">passed</font></th>
                                    <th><font style="font-family: Verdana;font-size: small">Name of</font> <br><font style="font-family: Verdana;font-size: small">Board/University</font></th>
                                    <th><font style="font-family: Verdana;font-size: small">Year of</font> <br><font style="font-family: Verdana;font-size: small"> Passing</font></th>
                                    <th><font style="font-family: Verdana;font-size: small">Total</font><br><font style="font-family: Verdana;font-size: small"> GPA</font></th>
                                    
                              </tr>   
                           </thead>
                            <tbody>
                           <tr>
                               <td><?php echo "10th"; ?></td>
                               <td><?php echo $row['sbroad'] ?></td>
                               <td><?php echo $row['spy'] ?></td>
                               <td><?php echo $row['sgpa'] ?></td>
                               
                           </tr>
                           <tr>
                               <td><?php echo "12th/Diploma"; ?> </td>
                               <td><?php echo $row['s12broad'] ?></td>
                               <td><?php echo $row['s12py'] ?></td>
                               <td><?php echo $row['s12gpa'] ?></td>
                               
                               
                           </tr>
                           
                            </tbody>
                       </table>
                       
                                   </center>
                               </div>
                            </div>
            </div>
                  <?php endwhile ;?>
          <?php
    
       function pre_r($array){
           echo'<pre>';
         print_r($array);
         echo '</pre>';
       
       }
    ?>           
             
                  </form>

</main>


<footer>
    <div class="container-fluid p-0">
      <div class="row text-left">
        <div class="col-md-5 col-sm-5">
          <h4 class="text-light">About us</h4>
          <p class="text-muted">Sayed Ashikul Islam <br>Medul Hasan</p>
          <p class="pt-4 text-muted">Copyright ©2019 All rights reserved | This project is made with by
            <span> Raptors</span>
          </p>
        </div>
        <div class="col-md-5 col-sm-12">
          <h4 class="text-light">Newsletter</h4>
          <p class="text-muted">Stay Updated</p>
          <form class="form-inline">
            <div class="col pl-0">
              <div class="input-group pr-5">
                <input type="text" class="form-control bg-dark text-white" id="inlineFormInputGroupUsername2" placeholder="Email">
                <div class="input-group-prepend">
                  <div class="input-group-text">
                    <a href=""><i class="fas fa-arrow-right"></i></a>
                  </div>
                </div>
              </div>
            </div>
          </form>
        </div>
        <div class="col-md-2 col-sm-12">
          <h4 class="text-light">Follow Us</h4>
          <p class="text-muted">Let us be social</p>
          <div class="column text-light">
            <a href="https://www.facebook.com/"  target="null"><i class="fab fa-facebook-f"></i></a>
            <a href="https://www.instagram.com/" target="null"><i class="fab fa-instagram"></i></a>
            <a href="https://twitter.com/" target="null"><i class="fab fa-twitter"></i></a>
            <a href="https://www.youtube.com/" target="null"><i class="fab fa-youtube"></i></a>
          </div>
        </div>
      </div>
    </div>
  </footer>


  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
    crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
    crossorigin="anonymous"></script>
  <script src="./main.js"></script>
</body>

</html>
