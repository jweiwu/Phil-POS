<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Meal Management - Phil POS</title>
			
		<link rel="stylesheet" href="dist/css/bootstrap.min.css">
		<link rel="stylesheet" href="sass/stylesheets/meal.css">
		<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css">
	</head>
	<body>

<!-- Navbar -->
<div class="main-container">
	

	<header>
		<button id="togg_menu">
		<span class="bars"></span>
		<span class="bars"></span>
		<span class="bars"></span>
	</button>

		<ul class="megaMenu">

			<li class="title"><h1>Menu</h1></li>
			<li class="stuff"><a href="">點餐</a></li>
			<li class="stuff"><a href="">新增餐點</a></li>
			<li class="stuff"><a href="">新增類別</a></li>
			<li class="stuff"><a href="">營收</a></li>
		</ul>
	</header>

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
							            <th>餐點類別</th>
							            <th>餐點名稱</th>
							            <th>餐點價格</th>
							        </tr>
							    </thead>
							    <tbody>
							      	<s:iterator value="meals">
							      	<tr>
							        	<td><a href="deleteMeal?mid=<s:property value="mid" />"><span class="glyphicon glyphicon-trash"></span></a></td>
							        	<td><s:property value="head" /></td>
							        	<td><s:property value="meal" /></td>
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
				<h1>餐點輸入</h1>
				<a href="#" class="close">&times;</a>
			
				<div class="content">
					<s:form action="insertMeal" method="post" namespace="/boss">
						<div class="group">
							<span class="icon glyphicon glyphicon-tag"></span>	
							<input type="text" name="meal" required>	
							<span class="highlight"></span>
	      					<span class="bar"></span>
	      					<label>Menu name</label>
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
						<div class="group">
							<span class="icon glyphicon glyphicon-cog"></span>	
							<!-- <select name="YourLocation" placeholder="餐點類別選擇"> -->
							<select name="hid">
								<s:iterator value="heads">　
								<option value="<s:property value="hid" />"><s:property value="item" /></option>
								</s:iterator>
							</select>
							<span class="highlight"></span>
	      					<span class="bars"></span>
						</div>
						<input type="submit" value="確認" class="button green cnter">
					</s:form>
				</div>
			</div>
		</div>
		<!-- End of 類別輸入欄 -->
<!-- Enf of content -->
		<script type="text/javascript" src="js/jquery-1.11.3.js"></script>			
		<script type="text/javascript" src="js/head.js"></script>	
		<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
	
	</body>
</html>