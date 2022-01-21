<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %> 
     <%@ page errorPage="ErrorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
	
	<div class="container-fluid " style="height: 100vh">
		<div class="row justify-content-center align-items-center" style="height: 100vh">
			<div class="col-8  d-flex  justify-content-center " >
				<div class="row justify-content-center  " style="height:90%">
				<div class="col-6 d-flex align-items-center border border-dark shadow rounded-sm">
					<img class="img-fluid" alt="temp" src="1.jpg" style="width:60vw ">
				</div>
				<div class="col-6 border border-dark bg-light shadow rounded-sm" style="height: 90%">
					<div class="heading	">
						<h4 class="mt-3" style="text-align: center;" >Sign Up</h4>
					</div>
					<spr:form class ="form was-validated "  action="reg_user_form.htm"  method="post" commandName="user" >
					 	<div class="">
					    <label style="font-size:3.5vh " for="exampleInputText1">Full Name</label>
					    <input required="required" minlength="3" maxlength="10" type="text" class="form-control is-valid" id="exampleInputText1" style="height: 7vh" name="userName">
					  </div>
					  <div class="">
					    <label style="font-size:3.5vh " for="exampleInputText1">User Name</label>
					    <input required="required" pattern="^[a-zA-Z ]*$" type="text" class="form-control is-valid" id="exampleInputText1" style="height: 7vh" name="userUserName">
					  </div>
					  <div class="">
					    <label style="font-size:3.5vh " for="exampleInputText1">Mobile No</label>
					    <input required="required" maxlength="10" minlength="10" type="text" class="form-control is-valid" id="exampleInputText1" name="userMobileNo">
					  </div>
					  <div class="">
					    <label style="font-size:3.5vh " for="exampleInputEmail1">Email address</label>
					    <input type="email" required="required"  pattern="^[a-z0-9](\.?[a-z0-9]){5,}@g(oogle)?mail\.com$"  class="form-control is-valid" id="exampleInputEmail1" aria-describedby="emailHelp" name="userMail">
					    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
					  </div>
					  <div class="">
					    <label style="font-size:3.5vh " for="exampleInputPassword1">Password</label>
					    <input required="required"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,15}" type="password" class="form-control is-valid" id="exampleInputPassword1" name="userPass">
					  </div>
					  <div class=" form-check">
					    <input type="checkbox" class="form-check-input" id="exampleCheck1">
					    <label class="form-check-label is-valid" for="exampleCheck1">Check me out</label>
					  </div>
					  <button type="submit" class="btn btn-primary mt-2">Submit</button>
					   <div class="row mt-2 mb-2 justify-content-between" >
					  	<a class="col-4 text-dark text-decoration-none" href="prep_log_user_form.htm" >Log In</a>
					  	<a class="col-6 text-dark text-decoration-none" href="index.jsp" >Back To Home</a>
					  </div>
					</spr:form>
				</div>
				</div>
			</div>
		</div>
		
	</div>
	
	<script>
	
		
	</script>
</body>
</html>