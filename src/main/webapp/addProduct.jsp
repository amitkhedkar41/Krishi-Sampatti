<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	.add
	{
		height: 500px;
		width: 700px;
		background-color: #e6ffe6;
		margin-left: 400px;
		margin-top: 100px;
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
<%
String email=(String)request.getAttribute("email");
String user=(String)request.getAttribute("user");
%>
	<div class="add">
	<div class="head"></div>
		<form action="addProduct" method="post">
			<input type="text" placeholder="Enter Product Name" name="pname" required="required">
			<input type="number" placeholder="Quantity" name="quantity" required="required">
			<input type="number" placeholder="Price/1KG" name="price" required="required">
			<input type="text" placeholder="Decription" name="desc">
			<input type="hidden" value=<%=user%> name="user">
			<input type="hidden" value=<%=email%> name="email">
			<div  class="btn">
			<button id="save">SAVE</button>
			</div>
		</form>
		<a href="log?user=<%=user%>"><button id="cancle">CANCLE</button></a>
		<%String message=(String)request.getAttribute("message"); %>
		<h5><%=message %></h5>
	</div>
</body>
</html>