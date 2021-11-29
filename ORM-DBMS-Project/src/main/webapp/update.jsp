<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Testing Page - Update</title>
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
	<a href="ViewServlet">View</a>
	<form action="UpdateServlet" method="get">
		<div>Patient ID :</div>
		<div>
			<input type="number" name="pid" id="pid"
				value="<%=request.getParameter("pid")%>" readonly="readonly" />
		</div>
		<div>Patient Name :</div>
		<div>
			<input type="text" name="pname" id="pname"
				value="<%=request.getParameter("pname")%>" />
		</div>
		<div>Patient Address :</div>
		<div>
			<input type="text" name="dept" id="dept"
				value="<%=request.getParameter("dept")%>" />
		</div>
		<div>Patient Salary :</div>
		<div>
			<input type="text" name="doctor" id="dpctor"
				value="<%=request.getParameter("doctor")%>" />
		</div>
		<div>
			<input type="submit" value="Update" />
		</div>

	</form>
	<%
	String f = (String) request.getAttribute("failure");
	%>
	<font color="red"> <%
 if (f != null)
 	out.println(f);
 %>
	</font>
</body>
</html>