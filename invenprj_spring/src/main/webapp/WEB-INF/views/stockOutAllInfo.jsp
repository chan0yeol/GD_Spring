<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출고정보</title>
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
			
				<a href="./stockAmount.do">출고량순위</a>
				<a href="./stockSales.do">매출순위</a>
			<div class="position-absolute top-0 end-0">
				<c:if test="${emp.deptno eq 70}">
					<a href="./stockOutServlet.do" class="btn btn-danger">출고 등록</a>
				</c:if>

				<input type="number" name="mgr" id="mgr" placeholder="사원번호입력"
					required="required">
				<button id="mgrSearch">검색</button>

			</div>
			<c:choose>
				<c:when test="${fn:length(StockOutList) eq 0 }">
					<h2>정보가 없습니다.</h2>
				</c:when>
				<c:otherwise>
					<h2>출고목록</h2>
					<table>
						<tr>
							<!--  <th></th>-->
							<th>ID</th>
							<th>제품아이디</th>
							<th>담당자</th>
							<th>수량</th>
							<th>날짜</th>
							<th></th>
						</tr>
						<c:forEach items="${StockOutList}" var="dto" varStatus="vs">
							<tr>
								<td><a href="./stockOutInfo.do?id=${dto.stock_id}">${dto.stock_id}</a></td>
								<td>${dto.product_id}</td>
								<td>${dto.stock_mgr}</td>
								<td>${dto.stock_amount}</td>
								<td>${dto.stock_date}</td>
								<td>
									<form action="./stockOutDelete" method="get">
										<input type="submit" value="${dto.stock_id}">
									</form>
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:otherwise>
			</c:choose>

		</div>
	</main>
</body>
<script type="text/javascript">
	
	document.querySelector("div.position-absolute>button").addEventListener('click', () => {
		var mgr = document.getElementById("mgr").value;
		console.log(mgr);
		//alert(mgr);
		if(mgr == '') {
			alert('사원번호 입력하세요');
		}else{
			location.href='./stockOutAllInfo.do?mgr='+mgr;	
		}
		
	})
</script>
</html>