<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link rel="stylesheet" href="sass/stylesheets/style.css">
	<link rel="stylesheet" href="dist/css/bootstrap.css">
	
	</head>
<body>
<div class="main-wrap">
	<header class="main-header">
			<!-- <h1>點餐系統</h1> -->
			<span>點餐系統</span>
			<span>
			<a href="todayOrders"><span class="glyphicon glyphicon-list-alt"></span></a>
			<a href="boss/head.html"><span class="glyphicon glyphicon-home"></span></a>
			</span>
	</header>
	<div class="container" style="text-align: center;">
				<h1>訂單資訊</h1>
				
				<form action="dayOrders" method="get">
					Date: <input type="date" name="createtime">
					<input type="submit">
				</form>
				
				<table class="rwd-table">
				  <tr>
				    <th>#</th>
				    <th>折扣</th>
				    <th>金額</th>
				    <th>時間</th>
				  </tr>
				  <s:iterator value="orders">
				  <tr>
				    <td><button class="order-detail btn" value="<s:property value="oid" />">i</button></td>
				    <td><s:property value="discount" /></td>
				    <td><s:property value="total" /></td>
				    <td><s:property value="createtime" /></td>
				  </tr>
				  </s:iterator>
				</table>
				
				<div class="pop">
				  <span>✖</span>
				  <h1>餐點明細</h1>
				  <table class="table" style="font-size: 24px;">
				    <tr>
				      <th>餐點名稱</th>
				      <th>數量</th>
				      <th>金額</th>
				  </table>

				</div>
				
				
	</div>
</div>
	<script type="text/javascript" src="js/jquery-1.11.3.js"></script>		
	<script type="text/javascript" src="dist/js/bootstrap.min.js"></script>	
	<script type="text/javascript" src="js/showorder.js"></script>	
	<script type="text/javascript" src="js/handlebars.runtime-v4.0.5.js"></script>	
	<script type="text/javascript" src="js/handlebars-v4.0.5.js"></script>	
	<script type="text/javascript" src="template/Nav.template.js"></script>	
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>

</body>
</html>