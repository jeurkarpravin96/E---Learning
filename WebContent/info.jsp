<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
    <table align="center" >
        <tr>
            <td> <%=request.getAttribute("msg")%></td>
        </tr>
        <tr>
            <td> <a href="index.jsp" >Home</a> </td>
        </tr>
    </table>
</body>
</html>
</body>
</html>