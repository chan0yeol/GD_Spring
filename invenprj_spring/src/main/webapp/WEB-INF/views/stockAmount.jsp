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
							<th>총출고량</th>
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