<%@page import="com.cdac.dto.Courses"%>
<%@page import="java.util.List"%>
<%@page import="com.cdac.dto.courseContent"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>  
    <%@ page errorPage="ErrorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Cintent</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<%@ include file="adminHeader.jsp" %>
	<div class="container" style="height: 100vh">
		<div class="row justify-content-center align-items-center" style="height: 100vh">
		<%
			courseContent courseCnt = (courseContent)request.getAttribute("cnt1");
			Courses crs = (Courses)request.getAttribute("course");
			System.out.println("updateCourse ="+crs);
			session.setAttribute("cid", crs.getCourseId());
			session.setAttribute("cntid",session.getAttribute("cntid"));
		%>
			<div class="col-6">
				<img class="img-fluid" alt="temp" src="3.jpg" style="width:70vw ">
			</div>
			<div class="col-6">

		 <spr:form action="update_content.htm" method="post"  commandName="cnt1" >
		 <h4 class="mb-2"  align="center">Update Lecture Content</h4>			
		 	<table align="center" class="table-border" >
				<tr>
					<td class="text-weight-bold">
						Lecture No :
					</td>
					<td >
						<spr:input class="form-control mb-2" path="lectureNo"/>
					</td >
				</tr>
				<tr >
					<td class="text-weight-bold">
						Lecture Name :
					</td>
					<td >
						<spr:input class="form-control mb-2" path="lectureName"/>
					</td>
				</tr>
				<tr>
					<td class="text-weight-bold">
						URL :
					</td>
					<td>
						<spr:input class="form-control mb-2" path="url"/>
					</td>
				</tr>
				<tr>
					<td class="text-weight-bold">
						Lecture Description : 
					</td>
					<td>
						<spr:textarea class="form-control mb-2" id="exampleFormControlTextarea4" path="lecDesc"/>
					</td>
								
			</table>
			<div class="row">
						<a class="btn btn-outline-primary " href="welcome_admin.jsp" >Back</a>
						<spr:button  class ="btn btn-outline-dark bg-info " > Update Content</spr:button> 					
				</div>
			
			</spr:form>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>