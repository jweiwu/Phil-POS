<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Phil-POS</title>
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="boss/dist/css/bootstrap.min.css">
<meta charset="UTF-8">
</head>

<body>
<div class="wrap">

</div>
<div class="cont">
     <div class="demo">
        <div class="login">
            <h2 class="title">菲爾漢堡</h2>
            <h2 class="title2">點餐系統登入</h2>
            <div class="login__form">
             
                <s:actionerror />
                <form action="login" method="post" autocomplete="off" >
                    <div class="login__row">
                        <i class="glyphicon glyphicon-user"></i>
                        <input class="login__input" type="text" name="username" size="20"  placeholder="Username"/>
                    </div>
                    <div class="login__row">
                        <i class="glyphicon glyphicon-lock"></i>
                        <input class="login__input" type="password" name="password" size="20" placeholder="Password" />
                    </div>
                     <input type="submit" class="login__submit" value="Submit" />
                 
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>



