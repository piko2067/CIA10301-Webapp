<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.shoppingcartlist.model.*"%>

<% 	//��com.emp.controller.EmpServlet.java��238��s�Jreq��empVO���� (������J�榡�����~�ɪ�empVO����)
	ShoppingcartlistVO shoppingcartlistVO = (ShoppingcartlistVO) request.getAttribute("shoppingcartlistVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>�ʪ�����Ʒs�W - addShoppingcartlist.jsp</title>

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
	width: 500px;
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
		 <h3>�ʪ�����Ʒs�W - addShoppingcartlist.jsp</h3></td><td>
		 <h4><a href="select_page.jsp"><img src="<%= request.getContextPath()%>/back-end/images/tomcat.png" width="100" height="100" border="0">�^����</a></h4>
		 								
	</td></tr>
</table>

<h3>��Ʒs�W:</h3>

<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="shoppingcartlist.do" name="form1">
<table>




	<tr>
		<td>�|���s��:</td>
		<td><input type="TEXT" name="memNo" value="<%= (shoppingcartlistVO==null)? "11" : shoppingcartlistVO.getMemNo()%>" size="45"/></td>
	</tr>
	<tr>
		<td>�ӫ~�s��:</td>
		<td><input type="TEXT" name="goodsNo" value="<%= (shoppingcartlistVO==null)? "11" : shoppingcartlistVO.getGoodsNo()%>" size="45"/></td>
	</tr>
	<tr>
		<td>�ӫ~�ƶq:</td>
		<td><input type="TEXT" name="goodsNum" value="<%= (shoppingcartlistVO==null)? "1" : shoppingcartlistVO.getGoodsNum()%>" size="45"/></td>
	</tr>
	<tr>
		<td>�ӫ~���:</td>
		<td><input type="TEXT" name="goodsPrice" value="<%= (shoppingcartlistVO==null)? "700" : shoppingcartlistVO.getGoodsPrice()%>" size="45"/></td>
	</tr>
	<tr>
		<td>�ӫ~�W��:</td>
		<td><input type="TEXT" name="goodsName" value="<%= (shoppingcartlistVO==null)? "Product K" : shoppingcartlistVO.getGoodsName()%>" size="45"/></td>
	</tr>
	<tr>
		<td>�q���`���B:</td>
		<td><input type="TEXT" name="orderTotalprice" value="<%= (shoppingcartlistVO==null)? "700" : shoppingcartlistVO.getOrderTotalprice()%>" size="45"/></td>
	</tr>
	
</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="�e�X�s�W"></FORM>

</body>

<!-- =========================================�H�U�� datetimepicker �������]�w========================================== -->

</html>