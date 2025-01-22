
function del(val) {
	console.log('삭제');
	location.href='./boardDelete.do?seq='+val;
}

function modify(val){
	console.log("수정 modal 버튼 클릭", val);
	$("tbody tr").css("background","white");
	var id = "[href*=collapse"+val+"]"; //
	$(id).closest("tr").css("background","yellow");
	
	ajaxModify(val);
	
}




var ajaxModify = (val) => {
	$.ajax({
		url:"./modifyForm.do",
		method:"POST",
		data: "seq="+val,
		success:function (data) {
			console.log("조회 결과 : ",typeof data,data);
			// TODO 014 Rest 수정 Form Modal 
			var json = JSON.parse(data);
			console.log("조회 결과 : ",typeof json,json);
			console.log()
			
			var html ="";
			
				html += "	<div class='form-group'>                                                                                "
	        	html += "		<label for='id'>아이디</label>                                                                      "
	        	html += "		<input type='hidden' name='seq' value='"+json.seq+"'>                                                           "
	        	html += "		<b class='form-control'>"+json.id+"</b>                                                                        "
	        	html += "	</div>                                                                                                  "
	        	html += "	<div class='form-group'>                                                                                "
	        	html += "		<label for='regdate'>작성일</label>                                                                 "
	        	html += "		<b class='form-control'>"+json.regdate+"</b>                                                                        "
	        	html += "	</div>                                                                                                  "
	        	html += "	<div class='form-group'>                                                                                "
	        	html += "		<label for='title'>제목</label>                                                                     "
	        	html += "		<input class='form-control' type='text' id='title' name='title' value='"+json.title+"' required='required'>       "
	        	html += "	</div>                                                                                                  "
	        	html += "	<div class='form-group'>                                                                                "
	        	html += "		<label for='content'>내용</label>                                                                   "
	        	html += "		<textarea class='form-control' rows='3' name='content' id='content'>"+json.content+"</textarea>                     "
	        	html += "	</div>                                                                                                  "
	        	html += "	<div class='modal-footer'>                                                                              "
				html += "        <button type='button' class='btn btn-secondary' data-dismiss='modal'>취소</button>               "
				html += "        <button type='reset' class='btn btn-info'>초기화</button>                                        "
				html += "        <button type='button' class='btn btn-primary' onclick='modifyVal()'>글 수정</button>             "
			    html += "    </div>                                                                                               "
			$("#frmModify").html("");
			$("#frmModify").append(html);
			
			$("#modify").modal({backdrop:"static",keyboard: "false"});
			$("#modify .modal-dialog").addClass("modal-sm");
		}, 
		error:function() {
			alert('잘못된 요청 입니다.');
		}	
	})
}


function modifyVal(){
	var frm = $("#frmModify");
	console.log(frm[0]);
	var page = $(".active").text();
	console.log(page);
	$.ajax({
		url:"./modify.do",
		type:"POST",
		data:frm.serialize(),
		success:function(msg){
			console.log("결과 : ", typeof msg, msg);
			if(msg.isc == true){
				 $("#modify").modal("hide");
				 spa_ajax(page);
			} else{
				location.href="./logout.do";
			}
		},
		error:function(e){
			alert("잘못된 요청입니다.",e);
		}
	});
}

// -- 답글 작성
function reply(val) {
	console.log('답글 이벤트 SEQ : ', val);
	ajaxReply(val);
	$("#reply").modal();
}

var ajaxReply = (seq) =>{
	$.ajax({
		url:"./replyForm.do",
		type:"POST",
		data:{seq:seq},
		dataType:"json",
		success:function(data){
			console.log(typeof data,data);
//			$("#frmReply").html("");
			
			// 1) javascript의 String Concatnation 방법으로 HTML String으로 만든 후 append
			var html = "";
//			html += "	<div class='form-group'>                                                                                "
//	        	html += "		<label for='id'>아이디</label>                                                                      "
//	        	html += "		<input type='hidden' name='seq'>                                                           "
//	        	html += "		<b class='form-control'>"+data.id+"</b>                                                                        "
//	        	html += "	</div>" 
//			$("#frmReply").append(html);
			
			// 2) jQuery의 DOM생성 
//			var div = $("<div>").attr("class","form-group");
//			var label = $("<label>").attr("for","id").text("아이디");
//			var b = $("<b>").attr("class", "form-control").text(data.id);
//			div.append(label).append(b);
//			$("#frmReply").append(div);			
//			
			 
			// 3) javascript CreateElement 방식
//			var div = document.createElement("div");
//			div.setAttribute("class","form-group");
//			var label = document.createElement("label");
//			label.setAttribute("for","id");
//			label.textContent = "제목";
//			var b = document.createElement("b");
//			b.setAttribute("class","form-control");
//			b.textContent = data.title;
//			div.appendChild(label);
//			div.appendChild(b);
//			document.getElementById('frmReply').appendChild(div);


			html += "    <div class= 'form-group '>"
	    	html += "		<input type='hidden' name='seq' value='"+data.seq+"'>"
	    	html += "		<label>부모글의 정보(seq :"+data.seq+" )</label> <br>"
	    	html += "		<b>작성일 : "+data.regdate+"</b>	        		"
	    	html += "	</div>"
	    	html += "	"
	    	html += "	<div class='form-group'>"
	    	html += "		<label>작성자</label>"
	    	html += "		<b>A003</b>"
	    	html += "	</div>"
	    	html += "	<div class='form-group'>"
	    	html += "		<label id='tit'>제목(원본)</label>"
	    	html += "		<input class='form-control' name='title' id='title' value='"+data.title+"' onclick='chk()'>"
	    	html += "	</div>"
	    	html += "	<div class='form-group'>"
			html += "<input type='hidden' id='hiddenContent' value='"+data.content+"'>";
	    	html += "		<label id='con'>내용(원본)</label>"
	    	html += "		<textarea class='form-control' rows='3' name='content' id='textValue' onclick='chk()'>"+data.content+"</textarea>"
	    	html += "	</div>"
	    	html += "	<div class='modal-footer'>"
	    	html += "		<input type='button' class='btn btn-success' value='답글 작성' onclick='replyVal()'>"
	    	html += "		<span onclick='reset()'><input type='reset' class='btn btn-info' value='초기화'></span>"
	    	html += "		<button type='button' class='btn btn-default' data-dismiss='modal'>취소</button>"
	    	html += "	</div>"
	    	
	    	$("#frmReply").html(html);
	    	
		},
		error:function(e){
			alert("잘못된 요청 처리");
		}
	});
} 


function chk(){
	var tit = document.getElementById('tit');
	var con = document.getElementById('con');
	var title =document.getElementById('title');
	var hiddenContent =document.getElementById('hiddenContent');
	var textValue =document.getElementById('textValue');
	
	console.log(tit, con, title, hiddenContent, textValue);
	
	if(textValue.value == hiddenContent.value) {
		tit.innerHTML = "답글 제목";
		con.innerHTML = "답글 내용";
		textValue.value="";
		title.value="";
	}
}

function reset() {
	document.getElementById('tit').innerHTML = "제목(원본)";
	document.getElementById('con').innerHTML = "내용(원본)";
}
// TODO 01502 답글 REST 요청
function replyVal() {
	var tit = document.getElementById('tit').textContent;
	if(tit == "제목(원본)") { // indexOf 사용하는게 좋음
		alert('답글 작성 오류\n답글 제목과 내용은 필수 입니다.');
		return; 
	}
	
	var parentSeq = document.getElementsByName('seq')[0].value;
	var title = document.getElementById('title').value;
	var textValue = document.getElementById('textValue').value;
	
	const extraTextPattern = /(<([^>])+>)/gi;
	let converTitle = title.replace(extraTextPattern,'');
	let converContent = textValue.replace(extraTextPattern,'');
	console.log(converTitle);
	console.log(converContent);
	
	var idx = $(".active").text();
	$.ajax({
		url:"./reply.do",
		method:"POST",
		data:{seq:parentSeq,title:converTitle,content:converContent},
		success:function(msg) {
			console.log('처리 결과 : ', typeof msg, msg);
			if(msg.isc == true){
				$("#reply").modal('hide');
				spa_ajax(idx);
			} else{
				alert('답글작성 오류');
			}
		},
		error:function() {
			alert('잘못된 요청 처리');
		}
	});
}











					