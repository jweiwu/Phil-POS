<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Head Management - Phil POS</title>
			
		<link rel="stylesheet" href="dist/css/bootstrap.min.css">
		<link rel="stylesheet" href="sass/stylesheets/meal.css">
		<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css">
	</head>
	<body>

<!-- Navbar -->
		<header class="main-header">
			<!-- <h1>點餐系統</h1> -->
			<span>點餐系統</span>
			<ul>
				<li class="stuff"><a href="../order.html">點餐</a></li>
				<li class="stuff"><a href="meals">新增餐點</a></li>
				<li class="stuff"><a href="heads">新增類別</a></li>
				<li class="stuff"><a href="day_accounting.html">日營收</a></li>
				<li class="stuff"><a href="month_accounting.html">月營收</a></li>
			</ul>
	</header>

<!-- End of Navbar-->


<!-- main content -->

			<div class="container-fluid">
				<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
				<div class="item-view">
					<div class="title"><h1>餐點類別</h1></div>
					<form action="">
					<div class="button-box">
						<a href="#popup1" class="button btn btn-success">新增類別</a>
					</div>	
					<!-- 類別輸出表 -->
					<div class="table-box">
						<div class="table-wrap">
							<table id="table_id" class="display">
							    <thead>
							        <tr>
							            <th>刪除</th>
							            <th>類別名稱</th>
							        </tr>
							    </thead>
							    <tbody>
							        <s:iterator value="heads">
							        <tr>
							        	<td><a href="deleteHead?hid=<s:property value="hid" />"><span class="glyphicon glyphicon-trash"></span></a></td>
							        	<td><s:property value="item" /></td>
							        </tr>
							        </s:iterator>
							    </tbody>
							</table>
						</div>
					</div>
					</form>
					<!-- End of 類別輸出表 -->
					</div>
					</div>
				</div>
			</div>

		<!-- 類別輸入欄 -->
		<div id="popup1" class="overlay">
				<div class="popup">
					<h2>請輸入類別名稱</h2>
					<a href="#" class="close">&times;</a>
					<div class="content">
						<s:form action="insertHead" method="post" namespace="/boss">
						<input type="text" name="item">
						<input type="submit" value="確認">
						</s:form>
					</div>
			</div>
		</div>
		<!-- End of 類別輸入欄 -->
<!-- Enf of content -->
		<script type="text/javascript" src="js/jquery-1.11.3.js"></script>			
		<script type="text/javascript" src="js/head.js"></script>	
		<script type="text/javascript" src="js/handlebars.runtime-v4.0.5.js"></script>	
		<script type="text/javascript" src="template/Nav.template.js"></script>	
		<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
	
	</body>
</html>