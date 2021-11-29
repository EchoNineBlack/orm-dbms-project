<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Page</title>
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
	<a href="insert.jsp">Insert</a>
	<a href="delete.jsp">Delete</a>
	<a href="ViewServlet">View</a>
</body>
</html>