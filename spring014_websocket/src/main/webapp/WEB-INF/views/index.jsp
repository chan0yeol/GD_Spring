<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>채팅구현</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
	window.onload = function() {
		// TODO 003 1대N 채팅 
		document.querySelector(".btn-primary").onclick = () => {
			window.open('./chatOneToMany.do','Chat',"width=700px,height=800px,left=300px, top=50px;");
// 			location.href = "./chatOneToMany.do";
		}
		document.querySelector(".btn-success").onclick = () => {
// 			window.open('./chatGroup.do','Chat',"width=700px,height=800px,left=300px, top=50px;");
			location.href = "./chatGroup.do";
		}
	}
</script>
<body>
	<div class="container" style="margin-top:50px; text-align:center;">
		<button class="btn btn-primary">1:N 채팅</button>
		<button class="btn btn-success">그룹 채팅</button>
		
	</div>
</body>
</html>