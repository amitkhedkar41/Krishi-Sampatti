<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
}

.regPage {
	width: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

fieldset {
	background-color: #fff;
	border: 1px solid #ccc;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	padding: 20px;
	width: 300px;
}

legend {
	font-size: 24px;
	text-align: center;
	margin-bottom: 20px;
}

input[type="text"], input[type="email"], input[type="tel"], input[type="password"]
	{
	width: calc(100% - 20px);
	padding: 10px;
	margin-top: 10px;
	margin-bottom: 20px;
	border: 1px solid #ccc;
	border-radius: 4px;
}

button {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	font-size: 16px;
}

button:hover {
	background-color: #45a049;
}

a {
	text-decoration: none;
	color: #007bff;
}

a:hover {
	text-decoration: underline;
}

h4 {
	color: #d9534f;
	text-align: center;
	margin-top: 20px;
}

h5 {
	text-align: center;
	margin-top: 20px;
}
</style>
</head>
<body>
	<%
	String user = (String) request.getAttribute("user");
	%>
	<div class="regPage">
		<fieldset>
			<legend align="center">Register</legend>

			<form action="save" method="post">

				<input type="text" placeholder="First name" name="fname"
					required="required"> <input type="text"
					placeholder="Last name" name="lname"> <input type="email"
					placeholder="email id" name="email" required="required"> <input
					type="tel" placeholder="Phone no" name="phone" required="required">
				<input type="text" placeholder="Address" name="address"> <input
					type="password" placeholder="New password" name="password"
					required="required"> <input type="password"
					placeholder="Confirm password" name="cpassword" required="required">
				<input type="hidden" value=<%=user%> name="user">
				<button>REGISTER</button>
			</form>
			<a href="index.jsp"><button>CANCLE</button></a><br> <a
				href="log?user=<%=user%>"><h5>Existing user/Already have
					account?</h5></a>
			<%
			String message = (String) request.getAttribute("message");
			%>
			<%
			if (message != null) {
			%>
			<h4><%=message%></h4>
			<%
			}
			%>
		</fieldset>

	</div>
</body>
</html>