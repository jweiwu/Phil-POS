<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Phil-POS</title>
<link rel="stylesheet" href="css/login.css">

</head>
 
<body>

<div class="container">
<h2>Login</h2>
<s:actionerror />
<form action="login" method="post" autocomplete="off" >
    <div class="input-group">
        <label>Username: </label>
        <input class="box" type="text" name="username" size="20" />
    </div>
    <div class="input-group">
        <label>Password: </label>
        <input class="box" type="password" name="password" size="20" />
    </div>
    <div class="input-group">
        <input type="submit" class="btn" value="Login" />
    </div>
</form>
</div>
</body>
</html>