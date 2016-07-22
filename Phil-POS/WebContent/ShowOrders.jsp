<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
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
				<table class="rwd-table">
				  <tr>
				    <th>編號</th>
				    <th>折扣</th>
				    <th>金額</th>
				    <th>時間</th>
				  </tr>
				  <s:iterator value="orders">
				  <tr>
				    <td data-th="oid"><s:property value="oid" /></td>
				    <td data-th="discount"><s:property value="discount" /></td>
				    <td data-th="total"><s:property value="total" /></td>
				    <td data-th="createtime"><s:property value="createtime" /></td>
				  </tr>
				  </s:iterator>
				</table>
				
	</div>
</div>
	<script type="text/javascript" src="js/jquery-1.11.3.js"></script>		
	<script type="text/javascript" src="dist/js/bootstrap.min.js"></script>	
	<script type="text/javascript" src="js/order.js"></script>	
	<script type="text/javascript" src="js/handlebars.runtime-v4.0.5.js"></script>	
	<script type="text/javascript" src="js/handlebars-v4.0.5.js"></script>	
	<script type="text/javascript" src="template/Nav.template.js"></script>	
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
		
</body>
</html>