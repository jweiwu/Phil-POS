<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Head</title>
			
		<link rel="stylesheet" href="dist/css/bootstrap.min.css">
		<link rel="stylesheet" href="sass/stylesheets/meal.css">

		<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css">
	</head>
	<body>
		<section class="overlay-menu">
			<div class="container">
				<div class="row">
					<div class="col-lg-3"></div>
					<div class="col-lg-6">
						
						<ul>
							<li><a href="#home">Home</a></li>
							<li><a href="#about" class="about-click">About</a></li>
							<li><a href="http://skaih.logdown.com">Blog</a></li>
							<li><a href="#services" class="services-click">Skill</a></li>
							<li><a href="#contact" class="contact-click">Contact</a></li>
						</ul>
					</div>
				</div>
			</div>
		</section>
		<div class="main-container">
			<header class="main-header">
				<nav>
			<div class="navbar-brand"><a href="" class="logo-title"></a></div>
			
			<div class="menu">
				
				<div  class="menu-icon">
					<div class="menu-title">MENU</div>
					<span></span>
				</div>
			</div>
		</nav>	
			

			</header>
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
					</form>
					<!-- 類別輸出表 -->
					</div>
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
		<!-- 類別輸入 -->
		<script type="text/javascript" src="js/jquery-1.11.3.js"></script>		
		<script type="text/javascript" src="js/head.js"></script>	
		<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
	
	</body>
</html>