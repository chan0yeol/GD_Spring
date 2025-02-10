<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>1:N채팅 화면</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style type="text/css">
  	table{
  	border : 1px solid black;
  	}
  	.container{
  		width:600px;
  	}
  </style>
  <script type="text/javascript" src="./js/chatGroupOneToMany.js"></script>
</head>
<body>
	<div class="container">
		<table class="table">
			<tbody>
				<tr>
					<td align="center">
						<div id="resive_msg" style="overflow:scroll; width:100%; height:500px;">
							<input type="text" id="nickName" onkeypress="if(event.keyCode==13){$('#join_room').click()}" style="width:350px; line-height:1.2;">
							<input type="button" id="join_room" value="대화입장">
						</div>
					</td>
				</tr>
			</tbody>
		</table>
		<div id="chat_div" style="display:none;">
			<input type="text" id="chat" onkeypress="if((event.keyCode)==13){$('#chat_btn').click()}">
			<input type="button" id="chat_btn" style="width:100%;" value="전송">
		</div>
		<button class="btn btn-primary" style="display:none;" onclick="disconnection()">연결종료</button>
	</div>
</body>
</html>