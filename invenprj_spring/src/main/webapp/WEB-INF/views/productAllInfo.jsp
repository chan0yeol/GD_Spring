<%@page import="com.min.edu.dto.ProductInfoDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 정보전체조회</title>
<style type="text/css">
	.field {
	    display: flex;
	    justify-content: center;
	    margin-right: 30px;
	    margin-bottom: 10px;
	}
</style>
<title>제품게시판</title>
</head>
<body>
<div class="field">
	<input class="btn btn-success btn-lg" type="button" value="제품등록">
</div>
<div class="field">
<form method="post" action="./productAllInfo.do">
	<div class="field">
		<button type="submit" id="all" name="all">전체조회</button>
	</div>
</form>
<form method="post" action="./productInfo.do">
	<div>
		<input type="text" id="id" name="id" placeholder="조회할 제품코드 입력">
		<input type="submit" value="조회">
	</div>
</form>
<form method="post" action="./productMaker.do">
	<div class="field">
		<input type="text" id="maker" name="maker" placeholder="조회할 제품제조사 입력">
		<input type="submit" value="조회">
	</div>
</form>
<form method="post" action="./productName.do">
	<div class="field">
		<input type="text" id="name" name="name" placeholder="조회할 제품이름 입력">
		<input type="submit" value="조회">
	</div>
</form>
</div>
</body>
<script type="text/javascript">
	document.querySelector("input[type=button]").onclick=function()  {
		console.log("수정화면 이동");
		location.href="./productInsertServlet.do";
	}
</script>
</html>