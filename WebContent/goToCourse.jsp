<%@page import="java.util.Iterator"%>
<%@page import="com.cdac.dto.User"%>
<%@page import="com.cdac.dto.Courses"%>
<%@page import="com.cdac.dto.courseContent"%>
<%@page import="java.util.List"%>
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
 <% List<courseContent> li = (List<courseContent>) request.getAttribute("cntList");
    	Courses temp = (Courses)request.getAttribute("course");
    	User u = (User)request.getAttribute("u");
    	int cnid = (int)request.getAttribute("cnid");
    	String url="";
    	String lecDesc="";
    	Iterator<courseContent> it = li.iterator();
		while(it.hasNext()){
			courseContent ccnt = it.next();
			if(ccnt.getContentId() == cnid){
				url=ccnt.getUrl();
				lecDesc=ccnt.getLecDesc();
			}
		}
    %>
	<div class="container-fluid" style="height: 100vh">
		<div class="row bg-light" style="height: 100%">
			<div class="col-8 ">
				<div class="mt-2  mb-2 embed-responsive embed-responsive-16by9">
					<iframe class="embed-responsive-item ml-2" width="" height="200" src=<%= url
					%> frameborder="0" allowfullscreen> </iframe>
				</div>
				<div class="mt-3">
					<h4 class="card-header">Description</h4>
					<div class="card-body">
						<span class="card-text" style="font-size: 2vh"><%= lecDesc
						%></span>
					</div>
				</div>
			</div>
			
			<div class=" col  card bg-light  ">
		<h4 class="card-header">Course Content</h4>
			<%
			for(courseContent c : li){	
		%>
				<div class="row  justify-content-start text-dark " >
					<span class="ml-3 " style="font-weight: bold;font-size:3vh;margin-bottom: 2px"><%=c.getLectureNo() %>.</span>
					
					<div class="ml-1 " style="margin-bottom: 2px;font-size:3vh"><a href="go_to_course.htm?cid=<%=temp.getCourseId()%>&cnid=<%=c.getContentId() %>"><%=c.getLectureName() %></a></div>
				</div>
		<div class="row" style="height: 10px"></div>
		<% } %>
		</div>
		</div>	
		
		
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>