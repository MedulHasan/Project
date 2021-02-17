<!DOCTYPE html>
<html lang="en">

<head>

<?php
        $mysqli=  mysqli_connect("localhost","root","","project") or die (mysqli_error($mysqli));
      $result=$mysqli->query("SELECT * FROM form")or die($mysqli->error);
       ?>
     
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <title></title>
        
        <link type="text/css" rel="stylesheet" href="admform.css"></link>
        
         <link rel="stylesheet" href="bootstrap.min.css">
         <link rel="stylesheet" href="bootstrap-theme.min.css">
       <script src="jquery.min.js"></script>
        <script src="bootstrap.min.js"></script>





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
            <li class="nav-item active_home">
              <a class="nav-link" href="#">Application Form
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="http://localhost/project/p/view/select_v.php">View Form</a>
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
   <section class="section-4">
      

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        
        <link type="text/css" rel="stylesheet" href="admform.css"></link>
         <script language="javascript" type="text/javascript" src="jquery-1.10.2.js"></script>
        
       

        <script type="text/javascript">
        function validate()
        {
            $('#adform input[type="text"]').each(function() {
                if(this.required)
                {
                    if(this.value=="")
                        $(this).addClass("inpterr");
                    else
                        $(this).addClass("inpterrc");
                }
              
                if($(this).attr("VT")=="NM")
                {
                    if((!isAlpha(this.value)) && this.value!="")
                    {
                       alert("Only Aplhabets Are Allowed . . .");
                       $(this).focus();
                    }
                }


                      

            });
        }
        
                function isAlpha(x)
                {
                    var re = new RegExp(/^[a-zA-Z\s]+$/);
                    return re.test(x);
                }
        
        </script>
        
        <style type="text/css">
            .inpterr
            {
                border: 1px solid red;
                background: #FFCECE;

            }
            
            .inpterrc
            {
                border: 1px solid black;
                background: white;
            }
        </style>
            
        
        
        
    </head>
     <body style="background-image:url('./images/inbg.jpg');">
            <div class="container-fluid">    
                <div class="row">
                  
                 </div>    
             </div>
            <div id="dmid" class="container-fluid">  
                
                 <div class="row">
                    <div class="col-sm-12">
                        <font style="color:white; margin-left:520px; font-family: Verdana; width:100%; font-size:30px;">
                        <b>ADMISSION FORM</b> </font>
                      </div>
                 </div>
                
             </div>
            
            <table class="frmtbl">
                
                <tr border="1" class="hdrow">
                    
                 </tr>       
                 
                  
          <form action="formdatabase.php" method ="POST">
                  <tr>
                    <?php

        $mysqli=  mysqli_connect("localhost","root","","project") or die (mysqli_error($mysqli));
        if (isset($_POST['btn1'])) {
      
  $email=$_POST['email'];
      $result=$mysqli->query("SELECT * FROM sign_up WHERE email='$email'")or die($mysqli->error);
       ?>
     
     
     
       
       <?php
          while($row = $result->fetch_assoc()):?>
        
         <!-- <td> <?php echo $row['id'];?></td> -->
         <tr>
                    <td> <font style="font-family: Verdana;">Student's Id.</font>  </td>
                    <td colspan="3"> <input type="text" id="uphn1" name="sid" value="<?php echo $row['id'];?>" placeholder="Id" required="true" VT="PH">
                  </tr>
          
    <?php endwhile ;?>
     
     
     
    
    <?php
    
       function pre_r($array){
           echo'<pre>';
         print_r($array);
         echo '</pre>';
       
       }
       
     }
    ?>
                  </tr>

                  <tr>
                    <td> <font style="font-family: Verdana;">Student's Name.</font>  </td>
                    <td colspan="3"> <input type="text" id="uphn1" name="sname" placeholder="Name" required="true" VT="PH">
                    <input type="text" id="uphn2" name="sphn" placeholder="Mobile Number" required="true" VT="PH"></td>
                  </tr>
                
                  <tr>
                    <td><font style="font-family: Verdana;"> Father's Name</font></td>
                    <td  colspan="3"> <input type="text" id="ufname" name="ufname" required="true" VT="NM"> </td>
                   </tr>
                 
                  <tr>
                    <td> <font style="font-family: Verdana;">Father's Occupation</font></td>
                    <td> <input type="text" id="ufocc" name="ufocc" required="true" VT="NM"> </td>
                    <td><font style="font-family: Verdana;"> Mobile No.</font></td>
                    <td> <input type="text" id="ufphn" name="ufphn" required="true" VT="PH"> </td>
                  </tr>
                
                <tr>
                    <td> <font style="font-family: Verdana;">Mother's Name</font> </td>
                    <td colspan="3"> <input type="text" id="umname" name="umname" required="true" VT="NM"></td>
                </tr>
                
                <tr>
                    <td> <font style="font-family: Verdana;">Mother's Occupation</font></td>
                    <td> <input type="text" id="umocc" name="umocc" required="true" VT="NM"> </td>
                     <td> <font style="font-family: Verdana;">Mobile No.</font></td>
                    <td> <input type="text" id="umphn" name="umphn" required="true" VT="PH"></td>
                </tr>
                
                <tr>
                    <td><font style="font-family: Verdana;"> Income of Parents </font>
                     <td  colspan="3"><input type="text" id="inc" name="inc" required="true" ></td>
                </tr>
                
                <tr>
                    <td> <font style="font-family: Verdana;">Sex </font>
                    <td><input type="radio" id="gen" name="gen" value="Male"><font style="font-family: Verdana;">Male</font>
                     <input type="radio" id="gen" name="gen" value="Female"><font style="font-family: Verdana;">Female </font></td>       
                    
                </tr>
                
                <tr>
                    <td><font style="font-family: Verdana;"> Present Address</font>
                    <td colspan="3"><br>
                          <input type="text" id="cast" name="div1" class="ad" placeholder="Division" style="margin-top: 4px;" required="true"><br>
                          <input type="text" id="capin" name="dis1" class="ad" placeholder="District" style="margin-top: 4px;" required="true"><br>
                          <input type="text" id="camob" name="vill1" class="ad" placeholder="Village" style="margin-top: 4px;" required="true"><br><br>
                </td>
                
                <tr>
                    <td> <font style="font-family: Verdana;">Permanent Address</font>
                    <td colspan="3"><br><br><br>
                          <input type="text" id="past" name="div2" class="ad" placeholder="Division" style="margin-top: 4px;" required="true"><br>
                          <input type="text" id="papin" name="dis2" class="ad" placeholder="District" style="margin-top: 4px;" required="true"><br>
                          <input type="text" id="pamob" name="vill2" class="ad" placeholder="Village" style="margin-top: 4px;" required="true"><br><br><br>
                    </td>
                </tr>   
               
                <br><br>
               
               <tr>
                    <td><font style="font-family: Verdana;">Choice of Branch</font></td>
                    <td><select id="brnc" name="brnc">
                         <option>--------------------Select--------------------</option>
                         <option>COMPUTER SCIENCE AND ENG</option>
                         <option>ELECTRICAL AND ELECTRONICS ENG</option>
                         <option>ELECTRONICS AND COMM ENG</option>
                         <option>CIVIL ENG</option>
                         <option>MECHANICAL ENG</option>
                         <option>ELECTRONICS ENG</option>
                         </select>
                     </td>
               </tr>
               
         
              <br><br>
                
                
               <tr>
                   <td><font style="font-family: Verdana;">Academic Qualification</font></td>
                   <td colspan="3">
                       <table class="table table-hover">
                           <thead>
                               <tr><br><br>
                                    <th><font style="font-family: Verdana;font-size: small">Exam</font> <br><font style="font-family: Verdana; font-size: small">passed</font></th>
                                    <th><font style="font-family: Verdana;font-size: small">Name of</font> <br><font style="font-family: Verdana;font-size: small">Board/University</font></th>
                                    <th><font style="font-family: Verdana;font-size: small">Year of</font> <br><font style="font-family: Verdana;font-size: small"> Passing</font></th>
                                    <th><font style="font-family: Verdana;font-size: small">Total</font><br><font style="font-family: Verdana;font-size: small"> GPA</font></th>
                                   
                              </tr>   
                           </thead>
                            <tbody>
                           <tr>
                               <td><?php echo "10th"; ?></td>
                               <td><input type="text" id="nob1" name="nob1" required="true"></td>
                               <td><input type="text" id="yop1" name="yop1" class="actab" required="true"></td>
                               <td><input type="text" id="tm1" name="tm1" class="actab" required="true"></td>
                               
                              
                           </tr>
                           <tr>
                               <td><?php echo "12th/Diploma"; ?> </td>
                               <td><input type="text" id="nob2" name="nob2" required="true"></td>
                               <td><input type="text" id="yop2" name="yop2" class="actab" required="true"></td>
                               <td><input type="text" id="tm2" name="tm2" class="actab" required="true"></td>
                               
                               
                           </tr>
                           
                            </tbody>
                       </table>
                                      
                           <br><br>
                           <tr>
                                <td colspan="4">
                                   <center> <input type="submit" onclick="validate();" id="frmnext" name="frmnext" value="Next"></center>
                                   
                                </td>
                           </tr>
                       </table>
             </form>
            <br>
                       
                            
            <br>
                       
                 
            </body>
</html>

    </section>
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