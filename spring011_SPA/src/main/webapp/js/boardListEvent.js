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

function reply(val) {
	
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