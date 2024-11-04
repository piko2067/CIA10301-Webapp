<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.shoppingcartlist.model.*"%>

<% //見com.emp.controller.EmpServlet.java第163行存入req的empVO物件 (此為從資料庫取出的empVO, 也可以是輸入格式有錯誤時的empVO物件)
  ShoppingcartlistVO shoppingcartlistVO = (ShoppingcartlistVO) request.getAttribute("shoppingcartlistVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>購物車資料修改 - update_shoppingcartlist_input.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>購物車資料修改 - update_shoppingcartlist_input.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="<%= request.getContextPath()%>/back-end/images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<h3>資料修改:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="shoppingcartlist.do" name="form1">
<table>
	<tr>
		<td>購物車清單編號:<font color=red><b>*</b></font></td>
		<td><%=shoppingcartlistVO.getShoppingcartListNo()%></td>
	</tr>
	<tr>
		<td>會員編號:</td>
		<td><input type="TEXT" name="memNo" value="<%=shoppingcartlistVO.getMemNo()%>" size="45"/></td>
	</tr>
	<tr>
		<td>商品編號:</td>
		<td><input type="TEXT" name="goodsNo" value="<%=shoppingcartlistVO.getGoodsNo()%>" size="45"/></td>
	</tr>
	<tr>
		<td>商品數量:</td>
		<td><input type="TEXT" name="goodsNum" value="<%=shoppingcartlistVO.getGoodsNum()%>" size="45"/></td>
	</tr>
	<tr>
		<td>商品單價:</td>
		<td><input type="TEXT" name="goodsPrice" value="<%=shoppingcartlistVO.getGoodsPrice()%>" size="45"/></td>
	</tr>
	<tr>
		<td>商品名稱:</td>
		<td><input type="TEXT" name="goodsName" value="<%=shoppingcartlistVO.getGoodsName()%>" size="45"/></td>
	</tr>
	<tr>
		<td>訂單總金額:</td>
		<td><input type="TEXT" name="orderTotalprice" value="<%=shoppingcartlistVO.getOrderTotalprice()%>" size="45"/></td>
	</tr>

</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="shoppingcartListNo" value="<%=shoppingcartlistVO.getShoppingcartListNo()%>">
<input type="submit" value="送出修改"></FORM>
</body>



<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->

</html>