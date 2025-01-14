<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출고 상세 정보</title>
<%@ include file="./header.jsp" %>
</head>
<body>
<main>
	<div class="container">
		<h2>출고 상세조회</h2>
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
				<td>${stockOut.stock_id}</td>
				<td>${stockOut.gubun}</td>
				<td>${stockOut.stock_date}</td>
				<td>${stockOut.stock_amount}</td>
				<td>${stockOut.stock_mgr}</td>
				<td>${stockOut.stock_cost}</td>
				<td>${product.product_maker}</td>
			</tr>
			<tr>
				<c:if test="${stockOut.stock_mgr eq emp.empno || emp.job eq '팀장' }">
					<button onclick="location.href='./stockOutUpdate.do?id='+${stockOut.stock_id}">수정</button>
				</c:if>
				<button onclick="history.back()">뒤로가기</button>
			</tr>
		</table>
	</div>
	
</main>
</body>
</html>