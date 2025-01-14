<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="./header.jsp" %>
</head>
<body>
<h1>${emp.ename}</h1>
	<main>
		<div class="container">
			<c:if test="${emp.deptno eq 70 && emp.job eq '팀장' }">
				<h2>
					<a href="./ManagerStockOut.do">관리자페이지 이동</a>
				</h2>
			</c:if>
			<c:choose>
				<c:when test="${fn:length(lists) eq 0 }">
					<h2>정보가 없습니다.</h2>
				</c:when>
				<c:otherwise>
					<h2>출고목록</h2>
					<table>
						<tr>
							<!--  <th></th>-->
							<th>순위</th>
							<th>제품아이디</th>
							<th>총매출액</th>
							<th>제품이름</th>
							<th>제조사</th>
						</tr>
						<c:forEach items="${lists}" var="dto" varStatus="vs">
							<tr>
								<td>${dto.original_cost}</td>
								<td>${dto.product_id}</td>
								<td>${dto.product_amount}</td>
								<td>${dto.product_name}</td>
								<td>${dto.product_maker}</td>
							</tr>
						</c:forEach>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
	</main>
</body>
</html>