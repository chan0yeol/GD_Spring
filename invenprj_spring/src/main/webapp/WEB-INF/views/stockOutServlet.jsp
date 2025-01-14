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
<%
// 	EmpDto s = (EmpDto)session.getAttribute("emp");
// 	List<ProductInfoDto> lists = (List<ProductInfoDto>)request.getAttribute("productList");
%>
<main>
	<div class="container">
		이름 : ${emp.ename} 사원번호 : ${emp.empno} 직급 : ${emp.job}
		<h3>출고 insert form</h3>
		 <div>
			<form method="post" action="./stockOutServlet.do">
				<!-- <input class="form-control" type="text" name="product_id" placeholder="제품번호" required="required"> <br /> -->
				<select name="product_id" class="form-select mb-3">
					<c:forEach items="${productList}" var="dto" varStatus="vs">
						<option value="${dto.product_id}">${dto.product_name}</option>
					</c:forEach>
				</select>
				<!--  <input type="text" name="stock_mgr" placeholder="담당자사원번호"> <br /> -->
				<input class="form-control" type="number" name="stock_amount" placeholder="수량" required="required"><br />
				<input type="submit" value="insert">
			</form>
		</div>
	</div>
	
</main>
</body>
</html>