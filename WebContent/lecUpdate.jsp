<%@page import="java.util.List"%>
<%@page import="com.cdac.dto.Courses"%>
<%@page import="com.cdac.dto.courseContent"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="ErrorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Lecture Content</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<%@ include file="adminHeader.jsp" %>
	<div class=" container card bg-light  ">
		<h4 class="card-header">Course Content</h4>
			<%
			List<courseContent> li = (List<courseContent>) request.getAttribute("cntList");
	    	Courses temp = (Courses)session.getAttribute("course");
			for(courseContent c : li){	
		%>
				<div class="row    text-dark " >
					<div class="col mt-2 d-flex justify-content-start ">
						<div class="ml-1 " style="margin-bottom: 2px;font-size:3vh">
						<span class="ml-3 " style="font-weight: bold;font-size:3vh;margin-bottom: 2px"><%=c.getLectureNo() %>.</span>
						<%=c.getLectureName() %>
						
						</div>
					</div>
					<div class="ml-1 mt-2 col d-flex justify-content-end" style="margin-bottom: 2px;font-size:3vh"><a  class="btn btn-outline-info" href="pre_update_content.htm?cid=<%=temp.getCourseId()%>&cnid=<%=c.getContentId() %>">Update Content</a></div>	
				</div>
		<div class="row" style="height: 10px">
		
		</div>
		<% } %>
		<h4 class=" "><a  href="pre_update_course_details.htm?cid=<%=temp.getCourseId() %>" class=" w-100 btn btn-outline-primary" >Back</a></h4>
		</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>