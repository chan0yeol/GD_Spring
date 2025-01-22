<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/handlebars@latest/dist/handlebars.js"></script>
  <script type="text/javascript" src="./js/boardListPage_HandleBars.js"></script>
</head>
<body>
	<!-- TODO 01601 페이징 HandleBarsJS 시작 -->
	<div class="container">
		<button onclick="handle_ajax(1)">페이징 Handlebars Template 처리 방법 </button>
	</div>
	<table class="table">
		
	</table>
	
	<!-- TODO 01603 template script 작성 -->
	<script type="text/x-handlebars-template" id="table-template">
			<thead>
				<tr class="info">
					
					{{#if showCheckBox}}
						<th>
							<input type="checkbox" class="allCheck" id="allCheck" onclick="checkAll(this.checked)">
						</th>
					{{/if}}
					<th>글번호</th>
					<th>작성자</th>
					<th>제목</th>
					
					{{#if showCheckBox}}
						<th>삭제여부</th>
					{{/if}}

					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				{{#each lists}}
					<tr>
						{{#if ../showCheckBox}}
							<td>
								<input type="checkbox" name="delCheck" value="{{seq}}">
							</td>
						{{/if}}

						<td>{{seq}}</td>
						<td>{{id}}</td>
						<td>
					 		<a data-toggle="collapse" data-parent="#accordion" href="#collapse{{seq}}">
								{{#if (contains delflag "Y")}}
									삭제된 글입니다.
									{{else}}
										{{{title}}}
								{{/if}}
							</a>
							
						</td>

						{{#if showCheckBox}}
							<td>{{delflag}}</td>
						{{/if}}


						<td>
							{{formatDate regdate}}
						</td>
					</tr>
					<tr>
						<td colspan="{{../colspan}}">
							<div id="collapse{{seq}}" class="panel-collapse collapse">
								<div class="form-group">
									<label>내용</label>
									<textarea class="form-control" rows="5" readonly="readonly">{{content}}</textarea>
									<div class="btn-group btn-group-justified">
										{{#if (equals ../memId id)}}
											<div class="btn-group">
												<button class="btn btn-info" onclick="modify({{seq}})">수정</button>
											</div>
										{{/if}}

										{{#if (or (equals ../memId id) ../showCheckBox)}}
											<div class="btn-group ">
												<button class="btn btn-danger" onclick="del({{seq}})">삭제</button>
											</div>
										{{/if}}

										{{#unless ../showCheckBox}}
											<div class="btn-group ">
												<button class="btn btn-default" onclick="reply({{seq}})">답글</button>
											</div>
										{{/unless}}
									</div>
								</div>
							</div>
						</td>
					</tr>
				{{/each}}
			</tbody>
			<tfoot style="text-align:center;">
				<tr>
					<td colspan="{{colspan}}">
						<ul class="pagination">
							{{#if hasPrevStage}}
								<li href="#" onclick="firstPage()"><a><span class="glyphicon glyphicon-fast-backward"></span></a></li>
							{{/if}}

							{{#if hasPrevPage}}
								<li href="#" onclick="pagePrev({{stagePage}},{{countPage}})"><a><span class="glyphicon glyphicon-chevron-left"></span></a></li>
							{{/if}}
							
							{{#each pages}}
							  <li {{#if isActive}} class="active" {{/if}}>
								<a href="javascript:page({{page}})">{{page}}</a>
								</li>
							{{/each}}
							
							{{#if hasNextPage}}

								{{#if ../hasNextStage}}
									<li><a href="#" onclick="pageNext({{stagePage}},{{countPage}})"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
								{{/if}}

									<li><a href="#" onclick="pageLast({{totalPage}})"><span class="glyphicon glyphicon-fast-forward"></span></a></li>
							{{/if}}

						</ul>
					</td>
				</tr>
			</tfoot>
	</script>
	
</body>
</html>