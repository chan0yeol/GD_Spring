<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<div class="container" style="width:500px; margin-top:100px;">
		<!-- TODO 010 국제화 코드 -->
		<select style="float:right;" id="lang" onchange="langChange()">
			<option value="ko" ${param.lang== "ko"?"selected":""}>한국어</option>
			<option value="en" ${param.lang== "en"?"selected":""}>영어</option>
		</select>
		<script type="text/javascript">
			function langChange(){
				var lang = document.getElementById('lang');
				var choiceLang = lang.options[lang.selectedIndex].value;
				console.log("선택된 언어 : ",choiceLang);
				location.href="./main.do?lang="+choiceLang;
			}
		</script>
		<form action="./login.do" method="POST">
			<table class="table">
				<caption style="text-align:center; font-size:20px;">
					<spring:message code="label.title"/>
				</caption>
				
				<tr>
					<th><spring:message code="label.id" /></th>
					<td>
						<input class="form-control" name="id" required="required">
					</td>
				</tr>
				<tr>
					<th><spring:message code="label.password"/></th>
					<td>
						<input class="form-control" type="password" name="password" required="required">
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:right;">
						
						<input type="submit" class="btn btn-warning btn-block" value="<spring:message code="label.login"/>">
						<input type="button" class="btn btn-info btn-block" value="회원가입 form validation" onclick ="location.href='./formValidation.do'">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>