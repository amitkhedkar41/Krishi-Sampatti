<%@page import="krishisampatti.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f0f0f0;
}

.main {
	height: 60px;
	width: 100%;
	background-color: #34495e;
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 0 20px;
}

.menu a {
	color: #fff;
	text-decoration: none;
	font-size: 18px;
	transition: color 0.3s;
}

.menu a:hover {
	color: #ffa500;
}

.container {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
	padding: 20px;
}

.prod {
	margin: 20px;
	padding: 20px;
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	width: 250px;
	transition: transform 0.3s;
}

.prod:hover {
	transform: translateY(-5px);
}

.prod p {
	margin: 0;
	font-size: 16px;
	line-height: 1.5;
}

.prod b {
	color: #333;
}

.prod img {
	max-width: 100%;
	height: auto;
	border-radius: 6px;
	margin-bottom: 10px;
}
</style>
</head>
<body>
	<%
	String email = (String) request.getAttribute("email");
	String user = (String) request.getAttribute("user");
	%>
	<div class="main">
		<div class="menu">
			<a href=""><button class="b1">HOME</button></a> <a
				href="prod?user=<%=user%>&email=<%=email%>"><button class="b1">POST</button></a>
			<a href="log?user=<%=user%>"><button class="b1"><%=email%>>
				</button></a> <a href=""><button class="b1">ABOUT</button></a> <a href=""><button
					class="b1">CONTACT</button></a>
		</div>
	</div>

	<%
	List<Product> list = (List) request.getAttribute("products");
	%>
	<div
		style="height: 1000px; width: 100%; background-color: #E0E0E0; margin-top: 20px; display: flex;">
		<%
		if (list == null) {
		%>
		<h2 style="color: red">Data not available</h2>
		<%
		} else {
		for (Product product : list) {
		%>
		<div class="prod" style="margin-right: 30px;">
			<div class="img"></div>
			<p>
				<b>Name:</b><%=product.getProductName()%><br> <b>Quantity:</b><%=product.getQuantity()%><br>
				<b>Price:</b><%=product.getPrice()%><br> <b>Description:</b><%=product.getDescription()%><br>
			</p>
		</div>
		<%
		}
		}
		%>

	</div>
</body>
</html>