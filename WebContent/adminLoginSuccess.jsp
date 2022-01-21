<%@page import="com.cdac.dto.Admin"%>
<%@page import="com.cdac.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>   
    <%@ page errorPage="ErrorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv = "refresh" content = "3; url = welcome_admin.htm" />
<title>Login Successful</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
 
</head>
<body>
<div class="container"  style="height: 100vh">
	<div class="row justify-content-center align-items-center" style="height: 100vh">
	<spr:form commandName="admin" method="GET">
	<% Admin admin = (Admin) session.getAttribute("admin_s"); %>
	<div class="alert alert-success" role="alert">
	  <h4 class="alert-heading">Success </h4>
	  <p>You Have Logged In Seccessfully <%= admin.getAdminName() %>!!</p>
	  <hr>
	  <p class="mb-0">The Secret to getting Done is Getting Started.</p>
	</div>
	</spr:form>
	</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>