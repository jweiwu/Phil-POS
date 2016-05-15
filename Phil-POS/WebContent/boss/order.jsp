<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link rel="stylesheet" href="sass/stylesheets/style.css">
	<link rel="stylesheet" href="dist/css/bootstrap.css">
	<script type="text/javascript" src="/dist/js/bootstrap.min.js"></script>
	</head>
<body>

<div class="main-wrap">
	<header class="main-header">
			<h1>Test</h1>
	</header>

	<div class="main-container">
		<div class="left">
			<div class="order">
			
				<div class="menu-item"> 
					<div class="row">
					 		<div class="food col-md-4"><p>墨西哥辣椒乳酪堡</p></div>
							<div class="col-md-5">
							<span class="">
									
									<input id="num" type="number" value="0">				
							</span>
					 		<span class="icon glyphicon glyphicon-plus" ></span>
						 	<span class="icon glyphicon glyphicon-minus">
						 		
						 	</span>
						 	<span class="icon glyphicon glyphicon-trash"></span>
							</div>
							<div class="col-md-3"><p>$100</p></div>
		 			</div>
				</div>	
				<div class="menu-item"> 
					<div class="row">
					 		<div class="food col-md-4"><p>墨西哥辣椒乳酪堡</p></div>
							<div class="col-md-5">
							<span class="">
									
									<input id="num" type="number" value="0">				
							</span>
					 		<span class="icon glyphicon glyphicon-plus" ></span>
						 	<span class="icon glyphicon glyphicon-minus">
						 		
						 	</span>
						 	<span class="icon glyphicon glyphicon-trash"></span>
							</div>
							<div class="col-md-3"><p>$100</p></div>
		 			</div>
				</div>			
				
				
			</div>
			<div id="acount">
				
				<form action="">
					<div></div>
					<div class="money"><p>消費金額:$</p><input type="text" value="4000"></div>
					
					<div class="btn btn-danger" >清除</div>
					<input class="btn btn-success"type="submit" value="結帳">

				</form>
			</div>

		</div>
		<div class="right">
			<div class="category">
				<div class="item col-md-3">漢堡</div>
				<div class="item col-md-3">飲料</div>
				<div class="item col-md-3">啤酒</div>
				<div class="item col-md-3">單點</div>
				
			</div>
		</div>
		<div class="clear"></div>
	</div>
</div>

<!-- Template -->
<script id="order-template" type="text/x-handlebars-template">
       	<div class="menu-item"> 
              <h6>{{menu_name}}</h6>
              <p>{{price}}</p>
              <hr>
        </div>
</script>
<!-- Template -->

<!-- <div class="menu-item"> 
		 <div class="row">
		 	<div class="col-md-5">墨西哥辣椒乳酪堡</div>
		<div class="col-md-5">
			<span class=""><input id="num" type="number" value="0"></span>
		 	<span class="glyphicon glyphicon-plus"></span>
			 	<span class="glyphicon glyphicon-minus"></span>
			 	<span class="glyphicon glyphicon-trash"></span>
			 </div>
		<div class="col-md-2">$100</div>
		 </div>
</div>
 -->

<script type="text/javascript" src="jquery-1.11.3.js"></script>	
<script type="text/javascript" src="handlebars-v4.0.5.js"></script>	
<script type="text/javascript" src="order.js"></script>	
<script type="text/javascript" src="js/handlebars.runtime-v4.0.5.js"></script>	
<script type="text/javascript" src="template/Nav.template.js"></script>	

</body>
</html>