<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="com.cdac.dto.User"%>
<%@page import="com.cdac.dto.Courses"%>
<%@page import="com.cdac.dto.courseContent"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% List<courseContent> li = (List<courseContent>) request.getAttribute("cntList");
    	Courses temp = (Courses)request.getAttribute("course");
    	User u = (User)request.getAttribute("u");
    %>
   <%@ page errorPage="ErrorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%=temp.getCourseName()%> Course</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<%@ include file="header.jsp" %>
	<div class="container" style="height: 100%">
		<div class="row bg-info " style="height: 60vh">
			<div class="col-6 mt-2  mb-2 embed-responsive embed-responsive-21by9">
				<iframe class="embed-responsive-item ml-2" width="200" height="100" src=<%=li.get(0).getUrl() %> frameborder="0" allowfullscreen> </iframe>
			</div>
			
			<div class="col-6 ">
				<div><h4 class="ml-4 text-black mt-2"><%=temp.getCourseName() %></h4></div>
				<div class="ml-4 mt-2" ><span class="mr-2" style="font-weight: bold">Created By :</span><%=temp.getCourseInstructor().toUpperCase() %></div>
				<div class="ml-4 mt-2" ><span class="mr-2"style="font-weight: bold">Language :</span><%=temp.getCourseLanguage() %></div>
				<div class="ml-4 mt-2" ><span class="mr-2"style="font-weight: bold">Updated Date :</span><%=temp.getCourseUpdatedate() %></div>
				<div class="ml-4 mt-2" ><span class="mr-2" style="font-weight: bold">Duration :</span><%=temp.getCouseHour() %> Hr</div>
				<div class="row justify-content-start mt-3 ml-3">
				<% 
				System.out.print(u.getCourses().contains(temp));
					boolean flag=false;
					Set<Courses> c1 = u.getCourses();
					Iterator<Courses> it = c1.iterator();	
					while(it.hasNext()){
						if(it.next().getCourseId() == temp.getCourseId()){
							flag=true;
						}
					}
				if( flag ){
					%>
					<div class="col">
					<button class="btn btn-outline-danger "> <a href="pre_go_to_course.htm?cid=<%=temp.getCourseId() %>&cnid=<%=li.get(0).getContentId() %>" style="color: white;text-decoration: none">Go To Course</a></button>
					</div>
				<% }else{
				 %>
					<div class="col-4  ">
					<button class="btn btn-outline-danger "> <a href="#" style="color: white;text-decoration: none"> Wishlist</a></button>
					</div class="col">
					<div>
					<button class="btn btn-outline-danger "> <a href="pre-enroll_course.htm?cid=<%=temp.getCourseId() %>&cnid=<%=li.get(0).getContentId() %>" style="color: white;text-decoration: none">Enroll</a></button>
					</div>
					<% }
				 %>
				</div>
			</div>
		</div>	
		<div class="row card mt-2">
			<h4 class="card-header">Description</h4>
			<div class="card-body">
				<span class="card-text" style="font-size: 2vh"><%=temp.getCourseDesc() %></span>
			</div>
		</div><hr>
		<div class=" row card bg-light mt-2 ">
		<h4 class="card-header">Course Content</h4>
			<%
			for(courseContent c : li){	
		%>
				<div class="row mb-2 justify-content-start text-dark " >
					<span class="ml-5 card-text" style="font-weight: bold"><%=c.getLectureNo() %> :</span> 
					<div class="ml-3	 card-text"><a href="#"><%=c.getLectureName() %></a></div>
				</div>
		<div class="row" style="height: 10px"></div>
		<% } %>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>