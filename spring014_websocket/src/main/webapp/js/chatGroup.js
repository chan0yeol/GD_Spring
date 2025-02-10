// TODO 014 그룹채팅 js 작성

var ws = null;
var url = null;
var nick = null;
var pageClosed = true;

$(document).ready(function(){
	
	console.log('그룹챝팅 로딩 ...');	
	url = location.href;
	var wsUrl = "ws:"+url.substring(url.indexOf("//"),url.lastIndexOf("/")+1)+"wsChatGr.do";
	console.log(wsUrl);
	var nick = document.querySelector("#nickName>b").textContent;
	var group = document.getElementById('group').textContent;
	console.log(`닉네임 : ${nick}, group : ${group}`);
	
	$(".chat").focus();
	
	// 웹소켓 객체 생성
	ws = new WebSocket(wsUrl);
	console.log("생성된 웹소켓 객체 : ",ws);
	
	// 객체 연결 후 open callback;
	ws.onopen = () => {
		console.log("웹소켓 객체 오픈");
		ws.send("#$nick_"+nickName);
	}
	
	// 서버로부터 전달받은 HandleTextMessage의 전달된 값 확인 및 화면 출력
	ws.onmessage = event =>{
		var msg = event.data;
		console.log(event, msg);
		if(msg.startsWith("<font style")) { // 입장과 퇴실 메시지
			$(".resive_msg").append($("<div class='noticeTxt'>").append(msg));
			// TODO 017 참여 목록 창 REST 처리, 입장/퇴장시 목록 갱신
			viewList(group);
			 
		} else if (msg.startsWith("[나]")) {
			$(".resive_msg").append($("<div class='sendTxt'>").append("<span class='send_img'>").append(msg));
		} else{
			$(".resive_msg").append($("<div class='resiveTxt'>").append("<span class='resive_img'>").append(msg));
		}
		$(".resive_msg").scrollTop($(".resive_msg")[0].scrollHeight);
	} 
	
	ws.onclose=()=>{
		alert('서버와 연결이 종료되었습니다. 채팅방이 삭제 됩니다.');
	}
	$(".chat_Btn").bind('click',()=>{
		if($(".chat").val() == ''){
			alert('메세지를 입력하세요');
		} else{
			ws.send(nick+":"+$(".chat").val());
			$(".chat").val("");
			$(".chat").focus();
		}
	});
	
	
	$(window).on('beforeunload',function (){
		event.preventDefault();
		event.returnValue = "";
		roomClose(); // 채팅방이 종료된 후 참여자 목록 갱신
		ws.close();
		ws = null;
		return '내용이 저장되지 않음';
	});
	
});
var roomClose = function () {
	alert('채팅방 종료');
	$.ajax({
		url:"./socketOut.do",
		type:"POST",
		async:true,
		success:function(){
			pageClosed = false;
			self.close();	
		}
	});	
}

// TODO 018 서버 호출 
function viewList(grid) {
	$(".memList").children().remove();
	$.ajax({
		url:'./viewChatList.do',
		type:'POST',
		data:"gr_id="+grid,
		dataType:"json",
		success:function(result) {
			console.log(result.list);
			for(let str in result.list){
				if(grid == result.list[str]){
					$(".memList").prepend("<p style='border-bottom:0.5px solid #ccc;'>"+str+"</p>");
				}
			}
		}
	});	
}











