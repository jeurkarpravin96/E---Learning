<%@page import="java.util.Map"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.cdac.serv.contentServImple"%>
<%@page import="com.cdac.serv.contentServ"%>
<%@page import="com.cdac.dao.ContentDao"%>
<%@page import="com.cdac.dao.contentDaoImple"%>
<%@page import="com.cdac.dto.courseContent"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="com.cdac.dto.Courses"%>
<%@page import="java.util.List"%>
<%@page import="com.cdac.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="ErrorPage.jsp" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container  " style="height: 100% ">
	<% User user = (User) session.getAttribute("user_s");
		System.out.print(user);
	%>
	<div class=" row " style="margin-top: 15vh">
			<h4  style="font-family:  'Indie Flower', cursive">Welcome <%= user.getUserUserName() %></h4>
		
	</div>
	<div class="row">
		<div class="col-6 d-flex align-items-center  rounded-sm">
					<img class="img-fluid" alt="temp" src="3.jpg" style="width:60vw ">
		</div>
		<div class="col-6 d-flex align-items-center  rounded-sm">
					<img class="img-fluid" alt="temp" src="4.jpg" style="width:60vw ">
		</div>
	</div>
	<div class="row shadow bg-info mt-2 mb-2 justify-content-center align-items-center"><h2 >Courses</h2></div>
		<% 
		List<Courses> li = (List<Courses>)request.getAttribute("courseList");
		for(Courses c : li){
			
		%>
		
		<!-- <div class="jumbotron jumbotron-fluid">
		  <div class="container">
		    <h1 class="display-4">Fluid jumbotron</h1>
		    <p class="lead">This is a modified jumbotron that occupies the entire horizontal space of its parent.</p>
		  </div>
		</div> -->
		
		
		<div class="row shadow jumbotron  jumbotron-fluid mb-2 justify-content-center  align-items-center bg-info p-2" >
			<div class="col-3   d-flex justify-content-center align-items-center ">
				<span class ="display-4 shadow p-1 mr-5"style="font-size: 4vh;font-weight: bold;">
				<%= c.getCourseName().toUpperCase() %>
				</span>
			</div>
			<div class="lead col-6 mb-2">
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
				<div class="row mt-4 ">
					<div class="col">
					<% 
					boolean flag=false;
					Set<Courses> c1 = user.getCourses();
					Iterator<Courses> it = c1.iterator();	
					while(it.hasNext()){
						if(it.next().getCourseId() == c.getCourseId()){
							flag=true;
						}
					}
				if( flag ){
					%>
					<div class="col">
					<button class="btn btn-outline-danger "> <a href="wgo_to_course.htm?cid=<%=c.getCourseId() %>" style="color: white;text-decoration: none">Go To Course</a></button>
					</div>
				<% }else{
				 %>
					<button class="btn btn-outline-danger"> <a href="pre_wishlist.htm?cid=<%=c.getCourseId() %>" style="color: white;text-decoration: none"> Wishlist</a></button>
					</div >
					<div class="col">
					<button class="btn btn-outline-danger"> <a href="pre-explore_course.htm?cid=<%=c.getCourseId() %>" style="color: white;text-decoration: none">Explore</a></button>
					<%} %>
					</div>
				</div>
			</div>
		</div>
		<% } %>	
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>