<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Head Management</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
 
<body>
	<div class="container">
    	<h2>Hello, <s:property value="#session.account.getName()" />!</h2>
    	<table class="table">
    		<thead>
    			<tr>
    				<th>類別</th>
    				<th>建立時間</th>
    			</tr>
    		</thead>
    		<tbody>
    		<s:iterator value="heads">
    			<tr>
    				<td><s:property value="item"/></td>
    				<td><s:property value="createtime"/></td>
    			</tr>
    		</s:iterator>
    		</tbody>
    	</table>
    </div>
</body>
</html>