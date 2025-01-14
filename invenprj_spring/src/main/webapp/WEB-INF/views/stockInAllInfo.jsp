<%@page import="com.min.edu.dto.StockDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재고조회 게시판</title>
<%@ include file="./header.jsp" %>
</head>

<body>
<div class="container">
	<table>
		<thead class="header">
			<tr>
				<th>제품코드</th>
				<th>입고수량</th>
				<th>출고수량</th>
				<th>재고</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${stockDto}" var="dto" varStatus="vs">
				<tr>
					<td>${dto.product_id}</td>
					<td>${dto.stock_amount}</td>
					<td>${dto.stock_mgr}</td>
					<td>${dto.stock_cost}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>