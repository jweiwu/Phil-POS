<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Welcome</title>
</head>
 
<body>
    <h2>Hello, <s:property value="#session.account.getName()" />!</h2>
    <ul>
    	<li><a href="boss/heads">Show Heads</a></li>
    	<li><a href="boss/heads">Show Meals</a></li>
    </ul>
</body>
</html>