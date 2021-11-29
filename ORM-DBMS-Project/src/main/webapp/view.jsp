<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Testing Page - View</title>
<script type="text/javaScript">
	function disableBackButton() {
		window.history.forward();
	}
	setTimeout("disableBackButton()", 0);
</script>
</head>
<body onload="disableBackButton()">
	<h1>
		Welcome
		<%=session.getAttribute("loginname")%></h1>
	<a href="LogoutServlet">Logout</a>
	<a href="menu.jsp">Menu</a>
	<a href="insert.jsp">Insert</a>
	<a href="delete.jsp">Delete</a>
	<table border="1">
		<tr>
			<th></th>
			<th>PId</th>
			<th>Pname</th>
			<th>Department</th>
			<th>Doctor</th>
		</tr>
		<c:forEach var="c" items="${patient }">
			<tr>
				<td><a
					href="update.jsp?pid=${c.pId }&pname=${c.pName }&dept=${c.dept }&doctor=${c.doctor }">Update</a></td>
				<td>${c.pId }</td>
				<td>${c.pName }</td>
				<td>${c.dept }</td>
				<td>${c.doctor }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>