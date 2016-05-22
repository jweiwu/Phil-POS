<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="/boss/sass/stylesheets/style.css">
	<link rel="stylesheet" href="/boss/dist/css/bootstrap.css">
	<script type="text/javascript" src="/boss/dist/js/bootstrap.min.js"></script>
<script>
	$(document).ready(function() {

		$.ajax({
			dataType: "json",
			url : "orderList",
			success : function(result) {
				str = "";
				
				for (i = 0; i < result.heads.length; i++) {
					str += '<div class="panel panel-primary"><div class="panel-heading">' + result.heads[i].item + '</div><div class="panel-body">';
					
					for (j = 0; j < result.meals.length; j++) {
						if (result.meals[j].hid == result.heads[i].hid) {
							str += result.meals[j].meal + "&nbsp;&nbsp;&nbsp;&nbsp;";
						}
					}
					
					str += "</div></div><br><br>";
				}

				$("#div1").html(str);
				
			}
		});
	});
</script>
<title>Order - Phil POS</title>
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
				<div class="item col-md-3"><button>漢堡</button></div>
				<div class="item col-md-3"><button>飲料</button></div>
				<div class="item col-md-3"><button>單點</button></div>
				<div class="item col-md-3"><button>分享餐</button></div>
				
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