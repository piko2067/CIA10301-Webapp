<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.shoppingcartlist.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
  ShoppingcartlistVO shoppingcartlistVO = (ShoppingcartlistVO) request.getAttribute("shoppingcartlistVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
<title>購物車資料 - listOneShoppingcartlist.jsp</title>

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
	width: 600px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<h4>此頁暫練習採用 Script 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>購物車資料 - listOneShoppingcartlist.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="<%= request.getContextPath()%>/back-end/images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>購物車清單編號</th>
		<th>會員編號</th>
		<th>商品編號</th>
		<th>商品數量</th>
		<th>商品單價</th>
		<th>商品名稱</th>
		<th>訂單總金額</th>
	</tr>
	<tr>
		<td><%= shoppingcartlistVO.getShoppingcartListNo() %></td>
        <td><%= shoppingcartlistVO.getMemNo() %></td>
        <td><%= shoppingcartlistVO.getGoodsNo() %></td>
        <td><%= shoppingcartlistVO.getGoodsNum() %></td>
        <td><%= shoppingcartlistVO.getGoodsPrice() %></td>
        <td><%= shoppingcartlistVO.getGoodsName() %></td>
        <td><%= shoppingcartlistVO.getOrderTotalprice() %></td>
	</tr>
</table>

</body>
</html>