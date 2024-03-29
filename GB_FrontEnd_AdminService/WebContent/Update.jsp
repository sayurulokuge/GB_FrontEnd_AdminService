<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

	<link rel="icon" type="image/gif/png" href="Images/logo.png">
	<title>GadgetBadget</title>

	<!-- css -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.css">
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css">
    <link rel="stylesheet" href="Views/update.css">
    
    <!-- js -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/flickity@2.0/dist/flickity.pkgd.min.js"></script>
    <script src="https://unpkg.com/swiper/swiper-bundle.js"></script>
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
    <script src="Components/Admin.js"></script>
    
</head>
<body>
	<div class="Fulscreen_slide">
        <div class="container-fluid p-0 m-0 inner_layer d-flex justify-content-center align-items-center">
	        <div class="jumbotron d-flex justify-content-center align-items-center p-0 col-6 h-75" id="flipJumbo">                  
	            <div class="front row">
	            
	            	<!-- left section of signup page -->
	                <div class="col-6 updateLeft">    
	                    <form id="Innovator" name="Innovator" class="text-center p-3" action="#" method="POST">
	
	                        <h1 class="h1 mb-0 d-flex flex-row">Update</h1>
	                        <small class="mt-0 text-muted mb-4">... Change is Welcome</small><br><br>	                        
	                         
	                        <div class="form-row mb-4 mt-3">     
	                            <div class="col">
	                                <!-- First name -->
	                                <input type="text" id="editFname" name="editFname" class="form-control" placeholder="First name">
	                            </div>
	                            <div class="col">
	                                <!-- Last name -->
	                                <input type="text" id="editLname" name="editLname" class="form-control" placeholder="Last name">
	                            </div>
	                        </div>
	
	                        <!-- E-mail -->
	                        <input type="email" id="editEmail" name="editEmail" class="form-control mb-4" placeholder="E-mail">
	
	                        <!-- Password -->
	                        <input type="password" id="editPW" name="editPW" class="form-control" placeholder="New Password">
	                        <small  class="form-text text-muted mb-3">At least 8 characters</small>
	
	                        <!-- Confirm Password -->
	                        <input type="password" id="editConfermPw" class="form-control mb-3" placeholder="Confirm Password" name="editConfermPw">
	                            
	                        <button id="btnUpdate" name="btnUpdate"class="btn my-4 btn-block update_btn" type="button">Update</button>
	                        <input type="hidden" id="hidInnovatorID" name="hidInnovatorID" value="">
	
	                    </form>
	                </div>
	                
	                <!-- right section of signup page -->
	                <div class="col-6 updateRight d-flex flex-column justify-content-center align-items-center">
	                    <div class=" updatelogomb-3 mb-3">
	                        <img src="Images/logo.png" class="signlogo ">
	                    </div>
	
	                    <h1 class="text-center"><b>Change is what</b></h1>
	                    <h1 class="text-center" style="font-weight: bold; font-style: italic; font-family: serif">The World Needs</h1>	
	                </div>
	                
	            </div>
	        </div>
        </div>
    </div>

</body>
</html>