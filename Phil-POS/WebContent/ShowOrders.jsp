<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Orders - Phil POS</title>
</head>
<body>
  <table style="border: 1px solid black">
    <s:iterator value="orders">
    <tr>
	  <td style="border: 1px solid black"><s:property value="oid" /></td>
	  <td style="border: 1px solid black"><s:property value="discount" /></td>
	  <td style="border: 1px solid black"><s:property value="total" /></td>
	  <td style="border: 1px solid black"><s:property value="createtime" /></td>
	</tr>
    </s:iterator>
  </table>
</body>
</html>