<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Login</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>
 
<body>

<div class="container">
<h2>Login</h2>
<s:actionerror />
<s:form action="login" method="post" namespace="/">
    <div class="form-group">
        <label>Username: </label>
        <input class="form-control" type="text" name="username" size="20" />
    </div>
    <div class="form-group">
        <label>Password: </label>
        <input class="form-control" type="password" name="password" size="20" />
    </div>
    <div class="form-group">
        <s:submit class="form-control" method="execute" align="center" value="Login" />
    </div>
</s:form>
</div>
</body>
</html>