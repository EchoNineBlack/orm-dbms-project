<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Testing Page - Insert</title>
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
	<a href="delete.jsp">Delete</a>
	<a href="ViewServlet">View</a>
	<form action="InsertServlet" method="get">
		<div>Patient ID :</div>
		<div>
			<input type="number" name="pid" id="pid" />
		</div>
		<div>Patient Name :</div>
		<div>
			<input type="text" name="pname" id="pname" />
		</div>
		<div>Patient Department :</div>
		<div>
			<input type="text" name="dept" id="dept" />
		</div>
		<div>Assigned Doctor :</div>
		<div>
			<input type="text" name="doc" id="doc" />
		</div>
		<div>
			<input type="submit" value="Insert" />
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