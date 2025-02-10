<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
		<!-- TODO 001 서버에 전송할 form 작성  -->
		<fieldset>
			<legend>서버에 전달하여 세션이 되는 값</legend>
			<form action="./login.do" method="post">
				<input name="name">
				<input type="submit" value="보내기">
			</form>
		</fieldset>
	</div>
</body>
</html>