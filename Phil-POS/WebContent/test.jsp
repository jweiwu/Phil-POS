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
	<input name="orders[0].oid" type="text" value="71">
	<input name="orders[0].discount" type="text" value="10">
	<input name="orders[0].total" type="text" value="500">
	<input name="orders[0].createtime" type="text" value="2016-5-22 22:47:30"><br>
	<input name="orders[1].oid" type="text" value="71">
	<input name="orders[1].discount" type="text" value="10">
	<input name="orders[1].total" type="text" value="500">
	<input name="orders[1].createtime" type="text" value="2016-5-22 22:47:30"><br>
	<input type="submit" >

</form>
</body>
</html>