<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>    
<%@ page errorPage="ErrorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<%@ include file="adminHeader.jsp" %>
	<div class="container" style="height: 100vh">
		<div class="row justify-content-center align-items-center" style="height: 100vh">
			<div class="col-6">
				<img class="img-fluid" alt="temp" src="1.jpg" style="width:70vw ">
				
			</div>
			<div class="col-6">
				<spr:form class="form was-validated" id="myform" action="course_add_form.htm" method="post"  commandName="course">
			<table align="center" class="table-border" >
				<tr>
					<td class="text-weight-bold">
						Course Name :
					</td>
					<td >
						<input required="required" id="cname" type="text" pattern="^[a-zA-Z ]*$" class=" is-valid form-control mb-2" name="courseName"/>
					</td >
				</tr>
				<tr >
					<td class="text-weight-bold">
						Instructor :
					</td>
					<td >
						<input class="form-control mb-2 is-valid" id="cIns" required="required" pattern="^[a-zA-Z ]*$" type="text" name="courseInstructor"/>
					</td>
				</tr>
				<tr>
					<td class="text-weight-bold">
						Duration :
					</td>
					<td>
						<input class="form-control mb-2 is-valid" id="cDur" required="required" pattern="^[0-9]*$" type="text" name="couseHour"/>
					</td>
				</tr>
				<tr>
					<td class="text-weight-bold">
						Last Updated : 
					</td>
					<td>
						<input required="required" placeholder="YYYY-MM-DD" id="cDate" pattern="\d{4}-\d{2}-\d{2}" type="text" class="is-valid form-control mb-2" name="courseUpdatedate" />
					</td>
				</tr>
				<tr>
					<td class="text-weight-bold">
						Language : 
					</td>
					<td>
						<input required="required" pattern="^[a-zA-Z ]*$" id="cLang" type="text" class=" is-valid form-control mb-2" name="courseLanguage"/>
					</td>
				</tr>
				<tr>
					<td class="text-weight-bold">
						Course Description : 
					</td>
					<td>
						<textarea required="required" id="cDesc"  class=" is-valid form-control mb-2" id="exampleFormControlTextarea4" name="courseDesc"></textarea>
					</td>
				<tr>
					<td>
						<a class="btn btn-outline-primary" href="welcome_admin.jsp" >Back</a>
					</td>
					<td>
						<input class="btn btn-outline-primary" type="submit"  value="Add Course Details" onclick="clearData()">
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