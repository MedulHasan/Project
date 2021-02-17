
<!DOCTYPE html>
<html lang="en">

<head>
        
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta http-equiv="X-UA-Compatible" content="ie=edge" />
  <title>Document file</title>

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
          <i class="fas fa-book-reader fa-2x mx-3"></i>Online Admission System</a>
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
              <a class="nav-link" href="#">View Form</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Edit Form</a>
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
      <?php

include 'fileupload.php';   
?>
<html>
    <body style="background-image:url('./images/inbg.jpg');">
        <form id="docup" enctype="multipart/form-data" name="docup" action="documents.php" method="post">
            <div class="container-fluid">    
                <div class="row">
                 </div>    
             </div>
            <div class="container" style="margin-left:100px;">
            <table class="table table-striped">
                            <thead>
                                       <tr>
                                           <th >
                                       <font style=" font-family: Verdana;  font-size:19px;"> Upload Your Documents</font>
                                           </th>
                                        </tr>           
                            </thead>
                            <tbody>
                            <tr>
                                 <td>Passport Size Image :</td>
                                 <td><input type="file" id="fpic" name="fpic" ><br>
                                     </td>
                            </tr> 
                           
                             <tr>
                                <td>10th Mark Sheet :</td>
                                <td>
                                     <input type="file" id="ftndoc" name="ftndoc"><br>
                                     
                                 </td>
                             </tr>
                             
                             <tr>
                                 <td>
                                     10th Certificate :
                                 </td>
                                 <td>
                                     <input type="file" id="ftcdoc" name="ftcdoc"><br>
                                     
                                 </td>
                             </tr>
                              
                             <tr>
                                 <td>
                                     12th/Diploma Mark Sheet :
                                 </td>
                             
                            
                                 <td>
                                     <input type="file" id="fdmdoc" name="fdmdoc"><br>
                                     
                                 </td>
                             </tr>
                             <tr>
                                <td>
                                    12th/Diploma Certificate :
                                </td>
                             
                                <td><input type="file" id="fdcdoc" name="fdcdoc"><br>
                                 </td>
                             </tr>
                             
                            <tr>
                                <td>
                                    Identity Proof
                                </td>
                            
                                 <td>
                                    <input type="file" id="fide" name="fide"><br>
                                 
                                </td>
                            </tr> 
                            
                            <tr>
                                <td>
                                    Signature
                                </td>
                            
                                 <td>
                                    <input type="file" id="fsig" name="fsig"><br>
                                 
                                </td>
                            </tr>
                            
                            <tr>
                                
                                <td colspan="2"><input type="submit" id="fpicup" name="fpicup" value="Apply" class="toggle btn btn-primary"></td>
                            </tr>
                           
                           </tbody>
                       </table>
        </div>
           
        </form>
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