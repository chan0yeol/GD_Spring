<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<!-- 
		TODO 10618 pageContext PathVariable을 통한 값 처리 후 이동
	 -->
	<h2>@PathVariable을 통한 주소의 값을 추출 후 이동한 페이지</h2>
	${pageContext.request.requestURI} <br>
	${pageContext.request.requestURL} <br>
	${pageContext.request.contextPath} <br>
	
	<a href="${pageContext.request.contextPath}">이동</a>
</body>
</html> 