<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 전체 리스트 &amp; 입력</title>
</head>
<body>
	${lists}
	<fieldset>
		<legend>DTO/VO 방식으로 Parameter 처리</legend>
		<form action="./insertBoardDto.do" method="POST">
			<input type="text" name="id" value="금요일"> <br>
			<input type="text" name="title" value="금요일 다음 토요일"><br>
			<input type="text" name="content" value="주말이 지나면 월요일"><br>
			<input type="submit" value="전송">
		</form>
	</fieldset>
	<fieldset>
		<legend>Map 처리</legend>
		<form action="./insertBoardMap.do" method="post">
			<input type="text" name="id" value="금요일"><br>
			<input type="text" name="title" value="금요일 다음 토요일"><br>
			<input type="text" name="content" value="주말이 지나면 월요일"><br>
			<input type="submit" value="전송">
		</form>
	</fieldset>
	<fieldset>
		<legend>@RequestParam 을 통한 전송이름과 사용변수를 변경하여 처리, 값의 오류 처리</legend>
		<form action="./parameterName.do" method="post">
			<input type="text" name="a" value="한파 "><br>
			<input type="text" name="b" value="새추위"><br>
			<input type="text" name="c" value="오늘은 아침에 춥고 저녁에 덜 춥다"><br>
			<input type="submit" value="전송">
		</form>
	</fieldset>
	<fieldset>
		<legend>@PathVariable를 통해 주소를 값으로 만들어 처리</legend>
		<form action="./com/min/edu/user/pathVariable.do">
			<input type="submit" value="주소에서 Parameter 처리">
		</form>
	</fieldset>
	<fieldset>
		<legend>Transaction을 통한 @Transactional</legend>
		<form action="./transaction.do" method="post">
			<input type="text" name="id" value="트랜잭션 "><br>
			<input type="text" name="title" value="트랜잭션"><br>
			<input type="text" name="content" value="오늘은 아침에 춥고 저녁에 덜 춥다"><br>
			<input type="submit" value="전송">
		</form>
	</fieldset>
</body>
</html>