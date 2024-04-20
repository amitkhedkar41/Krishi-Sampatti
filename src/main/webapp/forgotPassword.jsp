<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	.forgot
	{
		height: 350px;
		width: 600px;
		background-color: #e6ffe6;
		margin-left: 400px;
		margin-top: 200px;
	}
	input {
		height: 30PX;
		width: 60%;
		margin-top: 30PX;
		margin-left: 100PX;
	}
	.btn{
		display: flex;
		margin-left: 100px;
		margin-top: 50px;
		padding-left: 60px;
	}
	#save{
		height: 30px;
		width:70px;
		margin-left: 40px;
		background-color: #ffcccc;
		border: none;
	}
	#cancle{
		height: 30px;
		width:70px;
		margin-left: 40px;
		background-color: #ffcccc;
		border: none;
	}
	.head{
		height: 30px;
		width: 100%;
	}
</style>
</head>
<body>
<%String user=(String)request.getAttribute("user"); %>
	<div class="forgot">
	<div class="head"></div>
		<form action="updatePassword" method="post">
			<input type="email" placeholder="Enter email id" name="email">
			<input type="password" placeholder="New password" name="password">
			<input type="password" placeholder="Confirm new password" name="cpassword">
			<input type="hidden" value=<%=user %> name="user">
			<div  class="btn">
			<button id="save">SAVE</button>
			</div>
		</form>
		<a href="login?user=<%=user%>"><button id="cancle">CANCLE</button></a>
		<%String message=(String)request.getAttribute("message"); %>
		<h5><%=message %></h5>
	</div>
</body>
</html>