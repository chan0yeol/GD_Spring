<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>home.jsp</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h3>SpringSession Cross Root </h3>
		<fieldset>
			
			applicationScope: ${applicationScope.loginInfo} <br>
			sessionScope : ${sessionScope.loginInfo } <br>
			<a href="./logout.do">로그아웃</a> <br>
			<a href="./index.do">index</a>
		</fieldset>
	</div>
	
</body>
</html>