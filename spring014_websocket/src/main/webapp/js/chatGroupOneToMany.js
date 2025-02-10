/** 
	TODO 009 WebSocket 객체를 생성하는데 서버의 WebSocket와 연결
*/

var ws = null; // 웹소켓 객체
var url = null; // 접속주소 
var nick = null; // 대화명

$(document).ready(function() {
	$("#nickName").focus();

	$("#join_room").bind('click', () => {
		console.log("닉네임 입력 유효성 검사")
		if ($("#nickName").val() == '') {
			alert('참여 이름은 필수값 입니다.');
			$("#nickName").focus();
			return;
		}
		nick = $("#nickName").val(); // 대화창에서 입력받은 닉네임 -> Server로 전송하여 (Map<WebScoketSession, nick>
		console.log("참여이름 : ", nick);

		$("#resive_msg").html(""); // 첫화면에 닉네임을 입력하는 창 제거
		$("#chat_div").show();
		$("#chat").focus();
		$(".btn-primary").show();
		url = location.href;
		console.log("location.href의 값", url);
		var wsUrl = url.substring(url.indexOf("//"), url.lastIndexOf("/") + 1);
		console.log("웹소켓 URL", `ws:${wsUrl}wsChat.do`);

		ws = new WebSocket(`ws:${wsUrl}wsChat.do`);
		console.log("생성된 WebSocket 객체: ", ws);
		ws.onopen = () => {
			console.log("웹소켓 객체 오픈");
			ws.send("#$nick_" + nick);
		}
		ws.onmessage = (event) => {
			console.log("data", event.data);
			$("#resive_msg").append(event.data + "<br>");
		}
		ws.onclose = () => {
			alert("웹소켓 객체 종료");
		}
	}); // join_room


	$("#chat_btn").bind('click', () => {
		console.log("대화 내용 전달");
		if ($("#chat").val() == '') {
			alert("대화내용을 입력해주세요");
			return;
		} else {
			ws.send("[" + nick + "]:" + $("#chat").val());
			$("#chat").val("");
			$("#chat").focus();
		}
	}); // chat_btn end


	window.addEventListener("beforeunload", event => {
		event.preventDefault();
		event.returnValue = "";
		ws.close();
		ws = null;
	});
});

function disconnection() {
	ws.close();
	ws = null;
	window.close();
} 