<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>

<style type="text/css">
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
}

.main {
	height: 450px;
	width: 320px;
	margin: 50px auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 5px;
	box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
}

.login {
	text-align: center;
}

.login img {
	height: 50px;
	width: 80px;
}

.data {
	height: 30px;
	width: 100%;
	margin-top: 20px;
	padding: 5px;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-sizing: border-box;
}

button {
	margin-top: 20px;
	width: 100%;
	padding: 10px;
	background-color: #4CAF50;
	color: white;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
}

button:hover {
	background-color: #45a049;
}

h5 {
	margin-top: 20px;
	font-size: 14px;
	color: #666;
}

#fp {
	text-decoration: none;
	color: #666;
}

#fp:hover {
	color: #333;
}

.error {
	color: red;
}
</style>
</head>
<body>
	<%
	String user = (String) request.getAttribute("user");
	%>
	<div class="main">
		<div class="login">
			<img alt="login logo"
				src=" https://e7.pngegg.com/pngimages/348/800/png-clipart-man-wearing-blue-shirt-illustration-computer-icons-avatar-user-login-avatar-blue-child-thumbnail.png"
				style="height: 70px; width: 100px; margin-left: 50%">
			<form action="login" method="post">
				<input class="data" type="email" placeholder="Enter email id"
					name="email"> <input class="data" type="password"
					placeholder="Enter password" name="password"><br> <br>
				<input type="hidden" value=<%=user%> name="user">
				<button>LOGIN</button>
			</form>
		</div>
		<a href="forgot?user=<%=user%>"><h5 id="fp">forgot password?</h5></a>
		<a href="register?user=<%=user%>"><h5>New User</h5></a>
		<%
		String message = (String) request.getAttribute("message");
		%>
		<%
		if (message != null) {
		%>
		<h4 align="center"><%=message%></h4>
		<%
		}
		%>
	</div>

</body>
</html>