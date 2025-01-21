<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>

<title>게시글 전체 조회</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="./js/boardListPage.js"></script>
  <script type="text/javascript" src="./js/boardListEvent.js"></script>
  <style>
	  table tbody tr:nth-child(even) td{
	  	padding:5px;
	  	border-top:0px;
/* 	  } */
  </style>
</head>
<body>
	<button onclick="location.href='./logout.do'">로그아웃</button>
	사용자 정보 : ${loginVo} <br>
	model page 정보 : ${page} <br>
	session page 정보 : ${sessionScope.row} <br>
	
	<hr>
	<div class="container">
		<table class="table table-hover" id="accordion">
			<thead>
				<tr class="info">
					<c:if test="${loginVo.auth eq 'A'}">
						<th>
							<input type="checkbox" class="allCheck" id="allCheck" onclick="checkAll(this.checked)">
						</th>
					</c:if>
					<th>글번호</th>
					<th>작성자</th>
					<th>제목</th>
					<c:if test="${loginVo.auth eq 'A'}">
						<th>삭제여부</th>
					</c:if>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lists}" var="vo" varStatus="vs">
					<tr>
						<c:if test="${loginVo.auth eq 'A'}">
							<td>
								<input type="checkbox" name="delCheck" value="${vo.seq}">
							</td>
						</c:if>
						<td>${page.totalCount -(page.page-1) * page.countList - vs.index}</td>
						<td>${vo.id}</td>
						<td>
					 		<a data-toggle="collapse" data-parent="#accordion" href="#collapse${vo.seq}">${vo.title}</a>
						</td>
						<c:if test="${loginVo.auth eq 'A'}">
							<td>${vo.delflag}</td>
						</c:if>
						<td>
							<fmt:parseDate var="patternDate" value="${vo.regdate}" pattern="yyyy-MM-dd HH:mm:ss" />
							<fmt:formatDate value="${patternDate}" pattern="yyyy년 MM월 dd일"/>
						</td>
					</tr>
					<!-- title 클릭했을때 아래 출력되는 Content의 내용영역 -->
					<tr>
						<td colspan="${loginVo.auth eq 'A'?6:4}">
							<div id="collapse${vo.seq}" class="panel-collapse collapse">
								<div class="form-group">
									<label>내용</label>
									<textarea class="form-control"rows="5" readonly="readonly">${vo.content}</textarea>
									<div class="btn-group btn-group-justified">
										<c:if test="${vo.id eq loginVo.id}">
											<div class="btn-group">
												<button class="btn btn-info" onclick="modify(${vo.seq})">수정</button>
											</div>
										</c:if>
										<c:if test="${vo.id eq loginVo.id || loginVo.auth eq 'A'}">
											<div class="btn-group ">
												<button class="btn btn-danger" onclick="del(${vo.seq})">삭제</button>
											</div>
										</c:if>
										<c:if test="${loginVo.auth eq 'U'}">
											<div class="btn-group ">
												<button class="btn btn-default" onclick="reply(${vo.seq})">답글</button>
											</div>
										</c:if>
									</div>
								</div>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot style="text-align:center;">
				<tr>
					<td colspan="${loginVo.auth eq 'A'?6:4}">
						<ul class="pagination">
							<c:if test="${page.stagePage > 1}">
								<li href="#" onclick="firstPage()"><a><span class="glyphicon glyphicon-fast-backward"></span></a></li>
							</c:if>
							<c:if test="${page.stagePage - page.countPage >= 0}">
								<li href="#" onclick="pagePrev(${page.stagePage},${page.countPage})"><a><span class="glyphicon glyphicon-chevron-left"></span></a></li>
							</c:if>
							
							<c:forEach var="i" begin="${page.stagePage}" end="${page.endPage}" step="1">
							  <li ${page.page == i?"class=active":""}><a href="javascript:page(${i})">${i}</a></li>
							</c:forEach>
							
							<c:if test="${page.page<page.totalPage}">
								<c:if test="${page.stagePage+page.countPage < page.totalCount}">
									<li><a href="#" onclick="pageNext(${page.stagePage},${page.countPage})"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
								</c:if>
									<li><a href="#" onclick="pageLast(${page.totalPage})"><span class="glyphicon glyphicon-fast-forward"></span></a></li>
							</c:if>
						</ul>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
	  <!-- Modal -->
	  <div class="modal fade" id="modify" role="dialog">
	    <div class="modal-dialog">
	    
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title">글수정</h4>
	        </div>
	        <div class="modal-body">
	        	<form method="POST" id="frmModify">
	        		
				        		
	        	</form>
	        </div>
	      </div>
	      
	    </div>
  </div>
</body>

<script type="text/javascript">
	$("table").click(function(){
		console.log("클릭");
		$(".collapse").on('show.bs.collapse', function(){
			$(".collapse.in").collapse('hide');
			$("tbody tr").css("background","white");
		})
	});
</script>
</html>









