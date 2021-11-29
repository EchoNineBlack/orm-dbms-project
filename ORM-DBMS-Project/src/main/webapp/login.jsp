<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<script type="text/javaScript">
	function disableBackButton() {
		window.history.forward();
	}
	setTimeout("disableBackButton()", 0);
</script>
</head>
<body onload="disableBackButton()">
	<form action="LoginServlet" method="post">
		<div>Doctor ID:</div>
		<div>
			<input type="number" name="did" id="did" />
		</div>
		<div>Password:</div>
		<div>
			<input type="password" name="dname" id="dname" />
		</div>
		<div>
			<input type="submit" value="Login" />
		</div>
	</form>
	<%
	String err = (String) request.getAttribute("error");
	if (err != null) {
	%>
	<font color="red"> <%
 out.println(err);
 }
 %>
	</font>
</body>
</html>