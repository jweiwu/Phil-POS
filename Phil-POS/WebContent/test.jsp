<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="boss/js/jquery-1.11.3.js"></script>

</head>
<body>
<div id="div1">123</div>
<form id="form1" action="insertOrder" method="post">
	<input name="order.discount" type="text" value="10">
	<input name="order.total" type="text" value="500"><br><br>
	<input name="orderList[0].mid" type="text" value="6">
	<input name="orderList[0].quantity" type="text" value="1"><br>
	<input name="customList[0].mid" type="text" value="6">
	<input name="customList[0].cid" type="text" value="1"><br>
	<input name="orderList[3].mid" type="text" value="9">
	<input name="orderList[3].quantity" type="text" value="2"><br>
	<input name="orderList[4].mid" type="text" value="10">
	<input name="orderList[4].quantity" type="text" value="1"><br>
	<input name="customList[4].mid" type="text" value="10">
	<input name="customList[4].cid" type="text" value="3"><br>
	<input type="submit" >

</form>
</body>
</html>