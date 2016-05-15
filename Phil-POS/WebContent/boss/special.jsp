<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Custom Management - Phil POS</title>
			
		<link rel="stylesheet" href="dist/css/bootstrap.min.css">
		<link rel="stylesheet" href="sass/stylesheets/meal.css">
		<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css">
	</head>
	<body>


<div class="main-container">
	
<!-- Navbar -->
	
	<header id="nav-template"></header>

<!-- End of Navbar-->



<!-- main content -->
	
			<div class="container-fluid">
				<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
				<div class="item-view">
					<div class="title"><h1>新增餐點</h1></div>
					<form action="">
					<div class="button-box">
						<a href="#popup1" class="button btn btn-success">新增</a>
					</div>	
					<!-- 類別輸出表 -->
					<div class="table-box">
						<div class="table-wrap">
							<table id="table_id" class="display">
							    <thead>
							        <tr>
							        	<th>刪除</th>
							            <th>特製</th>
							            <th>價格</th>
							          
							        </tr>
							    </thead>
							    <tbody>
							      	<s:iterator value="customs">
							      	<tr>
							        	<td><a href="deleteCustom?cid=<s:property value="cid" />"><span class="glyphicon glyphicon-trash"></span></a></td>
							        	<td><s:property value="item" /></td>
							        	<td><s:property value="price" /></td>
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
		</div>

		<!-- 類別輸入欄 -->
		<div id="popup1" class="overlay">
			<div class="popup">
				<h1>特製需求</h1>
				<a href="#" class="close">&times;</a>
			
				<div class="content">
					<s:form action="insertCustom" method="post" namespace="/boss">
						<div class="group">
							<span class="icon glyphicon glyphicon-tag"></span>	
							<input type="text" name="item" required>	
							<span class="highlight"></span>
	      					<span class="bar"></span>
	      					<label>Name</label>
      					</div>
							
						<div class="group">
							<span class="icon glyphicon glyphicon-usd"></span>	
							<input type="text" name="price" required>
							<span class="highlight"></span>
	      					<span class="bar"></span>
	      					<label>Price</label>
      					</div>
      					<!-- 
						<div class="group">
							<span class="icon glyphicon glyphicon-usd"></span>	
							<input type="text" name="discount" step="0.05" max="1" min="0.1" value="1" required>
							<span class="highlight"></span>x
	      					<span class="bar"></span>
	      					<label>Discount</label>
      					</div>
      					 -->
						
						<input type="submit" value="確認" class="button green cnter">
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