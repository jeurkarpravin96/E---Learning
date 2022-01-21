<%@page import="com.cdac.dto.Courses"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="ErrorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Courses</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<%@ include file="adminHeader.jsp" %>
	<div class="container  " style="height: 100% ">
	<div class="row">
		<div class="col-6 d-flex align-items-center  rounded-sm">
					<img class="img-fluid" alt="temp" src="3.jpg" style="width:60vw ">
		</div>
		<div class="col-6 d-flex align-items-center  rounded-sm">
					<img class="img-fluid" alt="temp" src="4.jpg" style="width:60vw ">
		</div>
	</div>
	
	<div class="row rounded bg-info shadow mt-2 mb-2 justify-content-center align-items-center"><h2 >Courses</h2></div>
		
		
		<% List<Courses> li = (List<Courses>)request.getAttribute("courseList");
			for(Courses c : li){
				
		%>
		<div class="row shadow	border rounded justify-content-center align-items-center bg-info" style="height:40vh">
			<div class="col-4   d-flex justify-content-center align-items-center">
				<span class="shadow mr-5" style="font-size: 4vh;font-weight: bold;">
				<%= c.getCourseName().toUpperCase() %>
				</span>
			</div>
			<div class="col-6 mb-2 ">
				<div class="row mb-2"> 
					<div class="col">
						<span style="font-weight: bold">Instructor</span> : <%= c.getCourseInstructor().toUpperCase()%>
					</div>
				</div>
				<div class="row mb-2 justify-content-start"> 
				<div class="col"><span style="font-weight: bold">Language :</span> <%=c.getCourseLanguage() %></div>
				<div class="col"></div>
				
								
				</div>
				<div class="row justify-content-between ">
					<div class="col "><span style="font-weight: bold">Date :</span><%=c.getCourseUpdatedate() %></div>
					<div class="col"><span style="font-weight: bold">Duration :</span> <%= c.getCouseHour()%> hr</div>
					
				</div>
				<div class="row mt-4">
					<div class="col">
					<button class="btn btn-outline-danger"> <a href="pre_update_course_details.htm?cid=<%=c.getCourseId() %>" style="color: white;text-decoration: none">Update</a></button>
					</div class="col">
					<div>
					<button class="btn btn-outline-danger"> <a href="delete_course.htm?cid=<%=c.getCourseId() %>" style="color: white;text-decoration: none">Remove</a></button>
					</div>
				</div>
			</div>
		</div>
		<div class="row" style="height: 10px">
		</div>
		<% } %>	
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>