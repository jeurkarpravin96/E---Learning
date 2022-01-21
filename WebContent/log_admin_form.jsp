<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Log In</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>



	<div class="container-fluid" style="height: 100vh">
		<div class="row justify-content-center align-items-center" style="height: 100vh">
			<div class="col-8  d-flex  justify-content-center " >
				<div class="row justify-content-center " style="height: 80vh">
				<div class="col-6 d-flex align-items-center border border-dark shadow rounded-sm">
					<img class="img-fluid" alt="temp" src="3.jpg" style="width:60vw ">
				</div>
				<div class="col-6 border border-dark shadow rounded-sm">
					<div class="heading	">
						<h4 class="mt-3" style="text-align: center;" > LOG IN</h4>
					</div>
					<spr:form class ="form was-validated" action="log_admin_form.htm" method="post" commandName="admin" >
					  <div class="form-group">
					    <label style="font-size:4.5vh " for="exampleInputEmail1">Email address</label>
					    <input  type="email" required="required"  pattern="^[a-z0-9](\.?[a-z0-9]){5,}@g(oogle)?mail\.com$" type="email" class="is-valid form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="adminMail">
					    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
					  </div>
					  <div class="form-group">
					    <label style="font-size:4.5vh " for="exampleInputPassword1">Password</label>
					    <input required="required"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,15}" type="password" class="form-control" id="exampleInputPassword1" name="adminPass">
					  </div>
					  <div class="form-group form-check">
					    <input type="checkbox" class="form-check-input" id="exampleCheck1">
					    <label class="form-check-label" for="exampleCheck1">Check me out</label>
					  </div>
					  
					   <div class="row mt-2 mb-2 justify-content-between" >
					   <button type="submit" class=" ml-2 btn btn-primary">Submit</button>
					  	<a class="col-3 mr-2 text-white text-decoration-none btn btn-primary" href="index.jsp" >Back</a>
					  </div>
					</spr:form>
				</div>
				</div>
			</div>
		</div>
		
	</div>

</body>
</html>