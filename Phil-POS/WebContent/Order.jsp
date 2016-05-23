<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="boss/dist/css/bootstrap.min.css">
<script src="boss/js/jquery-1.11.3.js"></script>
<script src="boss/dist/js/bootstrap.min.js"></script>
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

				$("category").html(str);
				
			}
		});
	});
</script>
<title>Order - Phil POS</title>
</head>
<body>
<div class="container">
	<h2>Order List</h2>
	<div id="div1" class="panel-group"></div>
</div>
</body>
</html>