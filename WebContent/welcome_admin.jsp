<%@page import="com.cdac.dto.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="ErrorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<% Admin a = (Admin)session.getAttribute("admin_s"); %>
	<div class="container-fluid  " style="height: 100vh"  >
	<div class="row " style="height: 15vh">
		
	</div>
		<div class="row justify-content-between" >
			<div class="col-5">
				<img class="" alt="temp" src="2.jpg" style="width: 55vw">
			</div>
			<div class="col-6">
				<div class="row mt-3  ml-5">
					<h3 style="font-family:  'Indie Flower', cursive">Welcome <%=a.getAdminName() %>!!!</h3>
				</div>
				<div class="row mt-4 ml-5 ">
					<div class="col-5 d-flex justify-content-center card ">
						<div class="btn btn-outline-info mt-2 mb-2 border border-radius-2 btn-dark"> <a class="text-decoration-none text-white" href="prep_admin_profile.htm">MyProfile</a></div>
					</div>
					<div class="col-5 card ml-4" >
						<div class="btn btn-outline-info mt-2 mb-2 border border-radius-2 btn-dark"><a class="text-decoration-none text-white" href="show_courses.htm"> Show Course</a></div>
					</div>
				</div>
				<div class="row mt-5 ml-5">
					<div class="col-5 card ">
						<div class="btn btn-outline-info mt-2 mb-2 border border-radius-2 btn-dark"> <a class="text-decoration-none text-white" href="prep_add_course_form.htm"> Add Course</a></div>
					</div>
					<div class="col-5 card ml-4" >
						<div class="btn btn-outline-info mt-2 mb-2 border border-radius-2 btn-dark"><a class="text-decoration-none text-white" href="prep_user_logs.htm"> User Log</a></div>
					</div>
				</div>
				<div class="row mt-5 ml-5 justify-content-center align-items-center">
					<div class="col-5 card mr-5" >
						<div class="btn btn-outline-info mt-2 mb-2 border border-radius-2 btn-dark"><a class="text-decoration-none text-white" href="index.htm"> Log Out</a></div>
					</div>
				</div>
			</div>
		</div> 
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
	
