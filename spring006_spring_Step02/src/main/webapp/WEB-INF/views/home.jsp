<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home.do 요청 페이지</title>
</head>
<body>
	<h2>처음 호출되는 home.do에서 실행됨</h2>
	<h4>
		RequestMapping에 의해서 실행된 메소드의 반환 이름이 없다면 <br> 
		DispatcherServlet은 해당 메소드명을  ViewResolver에 넘겨준다. <br>
		반환이 없거나 (void), 반환이 null이어도 해당 메소드 명으로 jsp를 호출한다.
	</h4>
	${name}
</body>
</html>