<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> -->
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Special</title>
			
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
			<li class="stuff"><a href="">特製</a></li>
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
							            <th>特製</th>
							            <th>價格</th>
							          
							        </tr>
							    </thead>
							    <tbody>
							      	
							      	<tr>
							      		 <td><a href="deleteMeal?mid=<s:property value="mid" />"><span class="glyphicon glyphicon-trash"></span></a></td>	
							        	 <td>加肉</td>
							        	 <td>20元</td>
							    
							        </tr>
							      	<tr>
							      		<td><a href="deleteMeal?mid=<s:property value="mid" />"><span class="glyphicon glyphicon-trash"></span></a></td>
							        	 <td>不加生菜</td>
							        	 <td>0元</td>
							        </tr>
							      	<tr>
							      		<td><a href="deleteMeal?mid=<s:property value="mid" />"><span class="glyphicon glyphicon-trash"></span></a></td>
							        	 <td>加醬</td>
							        	 <td>5元</td>
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
				<h1>特製需求</h1>
				<a href="#" class="close">&times;</a>
			
				<div class="content">
					<s:form action="" method="post" namespace="/boss">
						<div class="group">
							<span class="icon glyphicon glyphicon-tag"></span>	
							<input type="text" name="meal" required>	
							<span class="highlight"></span>
	      					<span class="bar"></span>
	      					<label>Special name</label>
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
		<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
	
	</body>
</html>