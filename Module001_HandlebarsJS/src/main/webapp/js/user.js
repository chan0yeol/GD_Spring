// handlebarsJS를 통해 컴파일하여 template를 화면에 출력
import { Ajax } from "./Ajax.js";

// index.jsp의 loadCommentsBtn 이벤트처리
document.getElementById('loadCommentsBtn').addEventListener('click', () =>{
var a = new Ajax().setHttpMethod("POST").setUrl("./AjaxJsonServlet");
	console.log("user.js에서 생성한 Ajax 클래스 : ",a);
	var data = a.callData();
	console.log("Ajax 실행 후 data ",data);
	
	var commentTemplate = document.querySelector("#commentTemplate").innerHTML;
	var commentBindTemplate = Handlebars.compile(commentTemplate);
	
	var resultHTML = "";
	resultHTML += commentBindTemplate(data);
	var commentUI = document.querySelector("#commentUi");
	commentUI.innerHTML = resultHTML;
});

//document.addEventListener("DOMContentLoaded",()=>{
//	document.getElementById('loadCommentsBtn').addEventListener('click', () => {
//		var a = new Ajax().setHttpMethod("POST").setUrl("./AjaxJsonServlet");
//		console.log("user.js에서 생성한 Ajax 클래스 : ",a);
//	});
//});