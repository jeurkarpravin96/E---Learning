<%@page import="com.cdac.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %> 
    <%@ page errorPage="ErrorPage.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Successful</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
 <meta http-equiv = "refresh" content = "3; url = pre-enroll_course.htm?cid="" />
</head>
<body>
	<spr:form commandName="user" method="GET">
	<% User user = (User) session.getAttribute("user_s"); %>
	<div class="alert alert-success" role="alert">
	  <h4 class="alert-heading">Great choice, <%= user.getUserName() %>!!</h4>
	  <p>You have Successfully enrolled in this Course.</p>
	  <hr>
	  <p class="mb-0">The Secret to getting Done is Getting Started.</p>
	</div>
	</spr:form>
</body>
</html>