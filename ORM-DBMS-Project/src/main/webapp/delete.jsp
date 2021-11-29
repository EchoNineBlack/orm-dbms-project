<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Testing Page - Delete</title>
<script type="text/javaScript">
	function disableBackButton() {
		window.history.forward();
	}
	setTimeout("disableBackButton()", 0);
</script>
</head>
<body onload="disableBackButton()">
	<a href="LogoutServlet">Logout</a>
	<a href="menu.jsp">Menu</a>
	<a href="insert.jsp">Insert</a>
	<a href="ViewServlet">View</a>
	<form action="DeleteServlet" method="get">
		<div>Customer ID :</div>
		<div>
			<input type="number" name="pid" id="pid" />
		</div>

		<div>
			<input type="submit" value="Delete" />
		</div>

	</form>
	<%
	String s = (String) request.getAttribute("success");
	String f = (String) request.getAttribute("failure");
	%>
	<font color="green"> <%
 if (s != null)
 	out.println(s);
 %>
	</font>
	<font color="red"> <%
 if (f != null)
 	out.println(f);
 %>
	</font>
</body>
</html>