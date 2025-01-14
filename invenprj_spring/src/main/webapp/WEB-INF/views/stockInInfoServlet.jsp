<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@ include file="./header.jsp" %>
<body>
<%
// 	StockDto stock = (StockDto)request.getAttribute("stockIn");
// 	ProductInfoDto product = (ProductInfoDto)request.getAttribute("product");
// 	EmpDto s = (EmpDto)session.getAttribute("emp");
%>
<main>
	<div class="container">
		<h2>입고 상세조회</h2>
		<table class="table">
			<tr>
				<th>제품ID</th>
				<th>제품명</th>
				<th>입고ID</th>
				<th>구분</th>
				<th>입고날짜</th>
				<th>수량</th>
				<th>담당자</th>
				<th>판매가</th>
				<th>브랜드</th>
			</tr>
			<tr>
				<td>${product.product_id}</td>
				<td>${product.product_name}</td>
				<td>${stockIn.stock_id}</td>
				<td>${stockIn.gubun}</td>
				<td>${stockIn.stock_date}</td>
				<td>${stockIn.stock_amount}</td>
				<td>${stockIn.stock_mgr}</td>
				<td>${stockIn.stock_cost}</td>
				<td>${product.product_maker}</td>
			</tr>
			<tr>
				<c:if test="${stockIn.stock_mgr eq emp.empno || emp.job eq '팀장' }">
					<button onclick="location.href='./stockInUpdate.do?id='+${stockIn.stock_id}">수정</button>
				</c:if>
				<button onclick="history.back()">뒤로가기</button>
			</tr>
		</table>
	</div>
	
</main>
</body>
</html>