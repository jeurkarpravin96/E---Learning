<%@page import="com.cdac.dto.Courses"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>  
    <%@ page errorPage="ErrorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Course Details</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<%@ include file="adminHeader.jsp" %>
<% Courses temp = (Courses)request.getAttribute("course");
		session.setAttribute("course", temp);
	%>
	<div class="container" style="height: 100vh">
		<div class="row justify-content-center align-items-center" style="height: 100vh">
			<div class="col-6">
				<img class="img-fluid" alt="temp" src="3.jpg" style="width:70vw ">
				
			</div>
			<div class="col-6">
				<spr:form class="form" action="update_course_details.htm" method="post"  commandName="course">
				<h4 align="center">Update Course Details</h4>
			<table align="center" class="table-border" >
			
				<tr>
					<td class="text-weight-bold">
						Course Name :
					</td>
					<td >
						<spr:input class="form-control mb-2" path="courseName"/>
					</td >
				</tr>
				<tr >
					<td class="text-weight-bold">
						Instructor :
					</td>
					<td >
						<spr:input class="form-control mb-2" path="courseInstructor"/>
					</td>
				</tr>
				<tr>
					<td class="text-weight-bold">
						Duration :
					</td>
					<td>
						<spr:input class="form-control mb-2" path="couseHour"/>
					</td>
				</tr>
				<tr>
					<td class="text-weight-bold">
						Last Updated : 
					</td>
					<td>
						<spr:input class="form-control mb-2" path="courseUpdatedate"/>
					</td>
				</tr>
				<tr>
					<td class="text-weight-bold">
						Language : 
					</td>
					<td>
						<spr:input class="form-control mb-2" path="courseLanguage"/>
					</td>
				</tr>
				<tr>
					<td class="text-weight-bold">
						Course Description : 
					</td>
					<td>
						<spr:textarea class="form-control mb-2" id="exampleFormControlTextarea4" path="courseDesc"/>
					</td>
				<tr>
					<td>
						<a class="btn btn-outline-primary" href="welcome_admin.jsp" >Back</a>
					</td>
					<td>
						<input class="btn btn-outline-primary" type="submit"  value="Update Course Details" >
					</td>
				</tr>
				
			</table>
			</spr:form>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

