<%@page import="com.min.edu.dto.ProductInfoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="productAllInfo.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 정보조회</title>
<style type="text/css">
	.header {
		text-align: center;
		background-color: #FAE0D4;
	}
</style>
</head>
<%
	ProductInfoDto dto = (ProductInfoDto)request.getAttribute("productDto");
%>
<body>
<div class="container">
	<table>
		<thead class="header">
			<tr>
				<th>제품코드</th>
				<th>이름</th>
				<th>제조사</th>
				<th>원가</th>
				<th>수량</th>
				<th>승인여부</th>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td><%=dto.getProduct_id()%></td>
					<td><%=dto.getProduct_name()%></td>
					<td><%=dto.getProduct_maker()%></td>
					<td><%=dto.getOriginal_cost()%></td>
					<td><%=dto.getProduct_amount()%></td>
					<td><%=dto.getIs_accepted()%></td>
				</tr>
		</tbody>
		<tfoot>
		</tfoot>
	</table>
</div>
</body>
</html>