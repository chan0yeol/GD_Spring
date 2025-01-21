/*
	BoardController의 boardList.do를통한 GET을 통한 MPA 방식의 개발
*/

//function firstPage() {
////	location.href="./boardList.do?page=1";
//}
//
//function pagePrev(stagePage, countPage) {
//	var page = (stagePage-countPage) < 0 ? 1:(stagePage-countPage);
////	location.href="./boardList.do?page="+page;
//}
//
//function page(page) {
////	location.href="./boardList.do?page="+page;
//}
//
//function pageNext(stagePage, countPage) {
////	location.href="./boardList.do?page="+(stagePage+countPage);
//}
//
//function pageLast(totalPage) {
////	location.href="./boardList.do?page="+totalPage;
//}

/*
	SPA 방식
 */
function firstPage() {
	console.log("첫 페이지 이동")

}

function pagePrev(stagePage, countPage) {
	var page = (stagePage - countPage) < 0 ? 1 : (stagePage - countPage);
	console.log("페이지 그룹 이전 이동")
}

function page(page) {
	console.log("선택된 페이지 이동")
	spa_ajax(page);
}

function pageNext(stagePage, countPage) {
	console.log("페이지 그룹 이후 이동")
}

function pageLast(totalPage) {
	console.log("마지막 페이지 이동")
}
// TODO 011 JS에서 ajax요청
var spa_ajax = (...args) => { // spread 표기법
	var choice_page = args[0];
	console.log(choice_page);

	$.ajax({
		url: "./page.do",
		method: "POST",
		data: { page: choice_page },
		dataType: "json",
		success: function(data) {
			console.log(data, typeof data);

			$.each(data, function(key, value) {
				console.log('사용되는 JSON의 key 값 :', key);

				// 권한에 따른 colspan의 갯수
				var n = $(".table tr:eq(0) th").length;
				console.log("length : ", n);

				var varHtml = "";

				if (key == "lists") {
					varHtml += "					<thead>"
					varHtml += "						<tr class='info'>"   
					if(n==6){
						varHtml += "								<th>                                                                                            "
					varHtml += "									<input type='checkbox' class='allCheck' id='allCheck' onclick='checkAll(this.checked)'>     "
					varHtml += "								</th>"
					}                                                                                    
					varHtml += "							<th>글번호</th>                                                                                     "
					varHtml += "							<th>작성자</th>                                                                                     "
					varHtml += "							<th>제목</th>      "
					if(n==6){
					varHtml += "								<th>삭제여부</th>                                                                               "	
					}                                                                                 
					varHtml += "							<th>작성일</th>                                                                                     "
					varHtml += "						</tr>                                                                                                   "
					varHtml += "					</thead>                                                                                                    "
					varHtml += "					<tbody>                                                                                                     "
					$.each(value,function(key,v){
					varHtml += "							<tr>                                                                                                "
					if(n==6){
					varHtml += "									<td>                                                                                        "
					varHtml += "										<input type='checkbox' name='delCheck' value='"+v.seq+"'>                               "
					varHtml += "									</td>                                                                                       "
					}
					
					varHtml += "								<td>"+v.seq+"</td>                          "
					varHtml += "								<td>"+v.id+"</td>                                                                               "
					varHtml += "								<td>                                                                                            "
					varHtml += "							 		<a data-toggle='collapse' data-parent='#accordion' href='#collapse"+v.seq+"'>"+v.title+"</a>"
					varHtml += "								</td>                                                                                           "
					if(n==6) {
					varHtml += "									<td>"+v.delflag+"</td>                                                                      "
					}

					let date = new Date(v.regdate);
					let datePrint = `${date.getFullYear()}년 ${date.getMonth()+1}월 ${date.getDate()}일`
					varHtml += "								<td>                                                                                            "
					varHtml += datePrint					
					varHtml += "								</td>                                                                                           "
					varHtml += "							</tr>                                                                                               "
					varHtml += "							<tr>                                                                                                "
					varHtml += "								<td colspan='"+n+"'>                                                       "
					varHtml += "									<div id='collapse"+v.seq+"' class='panel-collapse collapse'>                                "
					varHtml += "										<div class='form-group'>                                                                "
					varHtml += "											<label>내용</label>                                                                 "
					varHtml += "											<textarea class='form-control'rows='5' readonly='readonly'>"+v.content+"</textarea> "
					varHtml += "											<div class='btn-group btn-group-justified'>                                         "
					
					if(data.memId == v.id){
					varHtml += "													<div class='btn-group '>                                                    "
					varHtml += "														<button class='btn btn-info' onclick='modify("+v.seq+")'>수정</button>                              "
					varHtml += "													</div>                                                                      "
					}
					
					if(data.memId == v.id || n == 6) {
					varHtml += "													<div class='btn-group '>                                                    "
					varHtml += "														<button class='btn btn-danger' onclick='del("+v.seq+")'>삭제</button>                            "
					varHtml += "													</div>                                                                      "
					}					
					
					if(n != 6) {
					varHtml += "													<div class='btn-group '>                                                    "
					varHtml += "														<button class='btn btn-default' onclick='reply("+v.seq+")'>답글</button>                           "
					varHtml += "													</div>                                                                      "
					}
					
					varHtml += "											</div>                                                                              "
					varHtml += "										</div>                                                                                  "
					varHtml += "									</div>                                                                                      "
					varHtml += "								</td>                                                                                           "
					varHtml += "							</tr>                                                                                               "
						
					});
					varHtml += "					</tbody>                                                                                                    "
					varHtml += '<tfoot style="text-align:center;">'
					varHtml += "</tfoot>"
					
					
				} else if (key == "row") {
					varHtml += "<tr>"
					varHtml += "	<td colspan='"+n+"'>                                                                                                                    "
					varHtml += "		<ul class='pagination'>                                                                                                                                  "
					if(value.stagePage > 1){
					varHtml += "				<li href='#' onclick='firstPage()'><a><span class='glyphicon glyphicon-fast-backward'></span></a></li>                                           "
					}
					
					if(value.stagePage - value.countPage >= 0){
					varHtml += "				<li href='#' onclick='pagePrev("+value.stagePage+","+value.countPage+")'><a><span class='glyphicon glyphicon-chevron-left'></span></a></li>          "
					}
					
					for(let i =value.stagePage; i<=value.endPage;i++){
						let active = (value.page == i)?"class=active":"";
					varHtml += "			  <li "+active+"><a href='javascript:page("+i+")'>"+i+"</a></li>                                                              "
					}
					
					if(value.page < value.totalPage) {
						if(value.stagePage+value.countPage < page.totalCount){
							
							varHtml += "					<li><a href='#' onclick='pageNext("+value.stagePage+","+value.countPage+")'><span class='glyphicon glyphicon-chevron-right'></span></a></li>     "
						}
						varHtml += "					<li><a href='#' onclick='pageLast("+value.totalPage+")'><span class='glyphicon glyphicon-fast-forward'></span></a></li>                        "
					}
					varHtml += "		</ul>                                                                                                                                                    "
					varHtml += "	</td>"
					varHtml += "</tr>"
					
				}
				
				if(key == "lists"){
					$(".table").html(varHtml);
				} else{
					$("tfoot").append(varHtml);
				}
				
			});
		},
		error: function(err) {
			console.log("잘못된 ajax 요청");
		}
	});
}

