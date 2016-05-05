<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> -->
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

<!-- Navbar -->
<div class="main-container">
	<header class="main-header">
		<nav>
			<div class="navbar-brand"><a href="" class="logo-title"></a></div>
			
			<div class="menu">
				
				<div  class="menu-icon">
					<span></span>
				</div>
			</div>
		</nav>	
	</header>

<!-- End of Navbar-->



<!-- main content -->
	
			<div class="container-fluid">
				<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
				<div class="item-view">
					<div class="title"><h1>餐點</h1></div>
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
							            <th>餐點名稱</th>
							            <th>餐點類別</th>
							        </tr>
							    </thead>
							    <tbody>
							      		
							        <tr>
							        	<td><span class="glyphicon glyphicon-trash"></span></td>
							        	<td>雞排堡</td>
							        	<td>漢堡</td>
							        </tr>
							        
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
					<s:form action="" method="post" namespace="/boss">
						<div class="group">
							<span class="icon glyphicon glyphicon-tag"></span>	
							<input type="text" name="item" required>	
							<span class="highlight"></span>
	      					<span class="bar"></span>
	      					<label>Menu name</label>
      					</div>
							
							<div class="group">
							<span class="icon glyphicon glyphicon-usd"></span>	
							<input type="text" name="item" required>
							<span class="highlight"></span>
	      					<span class="bar"></span>
	      					<label>Price</label>
      					</div>
						<div class="group">
							<span class="icon glyphicon glyphicon-cog"></span>	
							<select name="YourLocation" placeholder="餐點類別選擇">
								　<option value="burger">漢堡</option>
								　<option value="drink">飲料</option>
								　<option value="coffee">咖啡</option>	
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