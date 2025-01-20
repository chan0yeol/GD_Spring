<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.8/handlebars.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script type="module" src="./js/user.js"></script>
</head>
<body>
	<div>
		<button id="loadCommentsBtn">load comments</button>
		<ul id="commentUi">
			<!-- TODO 001 플레이팅할 HTML 세팅이 되는 곳 
				 값의 바인딩 되는 부분은 mustache문법으로 처리한다.
			-->
		</ul>
	</div>
	
	<script type="template" id="commentTemplate">
	{{#each commonts}}
	<li>
		<div>
			<div>
				<p>{{comment}}</p>
			</div>
			<div>
				<div>
					<span>{{name}}</span>
				</div>
			</div>
		</div>
	</li>
	{{/each}}
	</script>
</body>
</html>