<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home 요청 페이지</title>
</head>
<body>
	<h2>처음 호출(home.do) 되는 페이지</h2>
	<fieldset>
		<ul>
			<li>parameter 값 : ${param.name}</li>
			<li>requestScope 값 : ${requestScope.rtnValue}</li>
			<li>Model로 넘긴 값 : ${rtnValue}</li>
		</ul>
	</fieldset>
	<fieldset>
		<legend>처리 방식에 따른 Controller 연습</legend>
		<ul>
			<li>
				<div>home.do를 Query과 함께 Get요청</div>
				<a href="./home.do?name=한글">Home.do Get</a>
			</li>
			<li>
				<div>@RequestMapping을 GET/POST 모든 처리 방식 호출 </div>
				<a href="./info.do">init.do 호출</a>
			</li>
			<li>
				<div>
					home.do POST로 요청하여 값 전달.
					<div style="width:300px; margin:20px auto; border:1px solid black;">
						<form action="./home.do" method="POST">
							이름 : <input name="name"> <br>
							나이 : <input type="number" name="age"> <br>
							주소 : <input name="address"> <br>
							<input type="submit" value="POST 전송">
						</form>
					</div>
				</div>
			</li>
			<li>
				<div>Spring 에서의 Redirect </div>
				<a href="./redircet.do?name=bananaa">redircet.do</a>
			</li>
		</ul>
	</fieldset>
	<fieldset>
		<legend>Controller에서 Indexing을 통한 요청</legend>
		<div>특정 요청(주소)에만 동작이 되는 Controller를 만들어 내기 위해, @PathVariable 화면 페이지의 요청을 처리하기 위해서 </div>
		
		<ul>
			<li>
				<div>Controller Indexing 처리 </div>
				<a href="./user/logout.do">/user/* 의 인덱싱처리</a>
			</li>		
		</ul>
	</fieldset>
</body>
</html>