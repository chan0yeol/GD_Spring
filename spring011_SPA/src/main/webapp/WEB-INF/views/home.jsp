<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>Insert title here</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<p>
			home.do에 의해 요청된 페이지 
		</p>
		<fieldset>
			<legend>session 유지 여부</legend>
			<ul>
				<li>사용자 정보 : ${loginVo}</li>
				<li>페이지 정보 : ${row}</li>
			</ul>
		</fieldset>
		<button onclick="location.href='./loginForm.do'">로그인 페이지로 이동</button>
	</div>
	
</body>
</html>