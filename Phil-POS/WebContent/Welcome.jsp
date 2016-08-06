<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Welcome</title>
</head>
 
<body>
    <h2>Hello, <s:property value="#session.account.getName()" />!</h2>
    <ul>
    	<li><a href="order.html">點餐</a></li>
    	<li><a href="boss/heads">管理類別</a></li>
    	<li><a href="boss/meals">管理餐點</a></li>
    	<li><a href="boss/customs">管理客製化</a></li>
    	<li><a href="boss/accounting.html">查詢營收</a></li>
    </ul>
</body>
</html>