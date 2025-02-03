<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 후 페이지</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
#page {
	width: 900px;
	margin: 0 auto;
}

#header {
	background-color: lightgrey;
	text-align: center;
}

#header>h1, #header>div {
	display: inline-block;
	line-height: 40px;
}

#nav li {
	display: inline-block;
	background-color: silver;
	height: 30px;
	text-align: center;
	margin-right: 10%;
}

#aside {
	border: 1px solid lime;
	width: 20%;
	min-height: 500px;
	float: left;
	line-height: 100px;
	list-style: none;
	padding-left: 10px;
}

#section {
	border: 1px solid lime;
	min-height: 500px;
	margin-left: 200px;
}

#footer {
	clear: both;
	height: 80px;
	background: lightgrey;
}

#footer p {
	text-align: center;
	line-height: 80px;
}
</style>
</head>
<body>
	<fieldset>
		<legend>scope 값</legend>
		<ol>
			<li>${requestScope.loginVo_m}</li>
			<li>${sessionScope.loginVo_s}</li>
			<li>${requestScope.loginVo_r}</li>
		</ol>
		<ol>
			<!-- TODO 02003 같은 이름의 요청이라면 Model이 우선 -->
			<li>${requestScope.containValue}</li>
			<li>${requestScope.containValue}</li>
		</ol>
	</fieldset>
	<div id="page">
		<header id="header">
			<h1>헤더영역</h1>
			${sessionScope.loginVo.name}님 반갑습니다.
			<c:if test="${loginVo.auth eq 'U'}">
				<div>
					<a href="#">[게시판 보기]</a>
				</div>
				<div>
					<!-- TODO 02101 로그아웃 시작
					
					 -->
					<a href="./logout.do">[로그아웃]</a>
				</div>
			</c:if>
		</header>
		<nav id="nav">
			<ul>
				<li>회사소개</li>
				<li>제품소개</li>
				<li>채용정보</li>
				<li>고객관리</li>
			</ul>
		</nav>
		<aside id="aside">
			<div>
				<ul>
					<li>회사연혁</li>
					<li>협력사</li>
					<li>매출</li>
				</ul>
			</div>
		</aside>
		<section id="section">
			<div>
				전달받은 Model 및 HttpSession 확인
				<ul>
					<li>Model의 loginVo값 : ${requestScope.loginVo.name}</li>
					<li>session의 loginVo값 : ${sessionScope.loginVo.name}</li>
				</ul>
			</div>
			<br>
			<div>
				콘텐츠 메뉴
				<ul>
					<!-- TODO 02104 session 확인 -->
					<li><a href="./sessionInit.do">HttpSession의 값을 확인해보자</a></li>
					<!-- TODO 02800 @ModelAttribute-->
					<li><a href="./modelAttribute.do">@ModelAttribute()</a></li>
				</ul>
			</div>
		</section>
		<footer id="footer">
			<div id="copy">
				<p>copyright&copy;</p>
			</div>
		</footer>
	</div>


</body>
</html>