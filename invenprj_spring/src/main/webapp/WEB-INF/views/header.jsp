<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
//	EmpDto s = (EmpDto)session.getAttribute("emp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
.form-signin form {
	width: 330px;
	margin: auto;
}

.nav-home {
	text-align: center;
}

ul.nav li {
	vertical-align: center;
}

header {
	background-color: snow;
}

.header-nav {
	width: 100%;
}

.header-nav .container {
	/* position: relative; */
	width: 1000px;
	height: 100px;
}

.header-nav .container div.link {
	position: relative;
	top: 25%;
	display: inline-block;
	width: 70px;
	height: 50px;
	text-align: center;
	padding: 5px;
	margin-left: 15px;
}

.header-nav .container div.link-right {
	position: relative;
	float: right;
	padding-top: 7px;
}

.link a {
	text-decoration: none;
}

main {
	clear: both;
	height: 700px;
}

main .container {
	position: relative;
	/* top:15%; */
}

a svg {
	color: grey;
}

a {
	color: rgb(31, 30, 30);
}

table {
	border: 2px solid black;
}

tr, td, th {
	border: 2px solid black;
}

td {
	width: 200px;
	text-align: center;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<!-- 각 페이지 link
		<h2><a href="./product.do">제품</a></h2>
		<h2><a href="./stockInAll">입고</a></h2>
	 -->
	<header class="header-nav">
		<div class="container">
			<div class="link">
				<a href="./"> <svg xmlns="http://www.w3.org/2000/svg" width="24"
						height="24" fill="currentColor" class="bi bi-house-door"
						viewBox="0 0 16 16">
                        <path
							d="M8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4.5a.5.5 0 0 0 .5-.5v-4h2v4a.5.5 0 0 0 .5.5H14a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293zM2.5 14V7.707l5.5-5.5 5.5 5.5V14H10v-4a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v4z">
                        </path>
                    </svg><br /> HOME
				</a>
			</div>
			<div class="link">
				<a href="./productAllInfo.do"> <svg
						xmlns="http://www.w3.org/2000/svg" width="24" height="24"
						fill="currentColor" class="bi bi-box-arrow-right"
						viewBox="0 0 16 16">
                        <path fill-rule="evenodd"
							d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0z" />
                        <path fill-rule="evenodd"
							d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708z" />
                    </svg><br /> 제품
				</a>
			</div>
			<div class="link">
				<a href="./stockInAllInfo.do"> <svg
						xmlns="http://www.w3.org/2000/svg" width="24" height="24"
						fill="currentColor" class="bi bi-box-arrow-right"
						viewBox="0 0 16 16">
                        <path fill-rule="evenodd"
							d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0z" />
                        <path fill-rule="evenodd"
							d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708z" />
                    </svg> <br /> 재고
				</a>
			</div>
			<div class="link">
				<a href="./stockAllInfo.do"> <svg
						xmlns="http://www.w3.org/2000/svg" width="24" height="24"
						fill="currentColor" class="bi bi-box-arrow-right"
						viewBox="0 0 16 16">
                        <path fill-rule="evenodd"
							d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0z" />
                        <path fill-rule="evenodd"
							d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708z" />
                    </svg> <br /> 입고
				</a>
			</div>
			<div class="link">
				<a href="./stockOutAllInfo.do"> <svg xmlns="http://www.w3.org/2000/svg"
						width="24" height="24" fill="currentColor"
						class="bi bi-box-arrow-right" viewBox="0 0 16 16">
                        <path fill-rule="evenodd"
							d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0z" />
                        <path fill-rule="evenodd"
							d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708z" />
                    </svg> <br /> 출고
				</a>
			</div>
			<c:if test="${emp ne null && emp.job eq '팀장' }">
				<div class="link">
					<c:choose>
						<c:when test="${emp.deptno eq 50 }">
							<a href="./ManagerProduct.do">
						</c:when>
						<c:when test="${emp.deptno eq 60 }">
							<a href="./ManagerStockIn.do">
						</c:when>
						<c:when test="${emp.deptno eq 70 }">
							<a href="./ManagerStockOut.do">
						</c:when>
					</c:choose>
					<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
						fill="currentColor" class="bi bi-box-arrow-right"
						viewBox="0 0 16 16">
	                        <path fill-rule="evenodd"
							d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0z" />
	                        <path fill-rule="evenodd"
							d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708z" />
	                    </svg>
						<br /> 관리자 </a>
				</div>
			</c:if>

			<div class="link link-right">
				<c:choose>
					<c:when test="${emp eq null}">
						<a href="./login">
							<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
						fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
	                        <path
							d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6m2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0m4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4m-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10s-3.516.68-4.168 1.332c-.678.678-.83 1.418-.832 1.664z" />
	                    </svg>
						</a>
					</c:when>
					<c:otherwise>
						<a href="./mypage">
							<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
								fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
			                        <path
									d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6m2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0m4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4m-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10s-3.516.68-4.168 1.332c-.678.678-.83 1.418-.832 1.664z" />
		                    </svg>
						</a>
					</c:otherwise>
				</c:choose>
				
			</div>
			<c:choose>
				<c:when test="${emp eq null}">
					<div class="link link-right">
						<a href="./"> <svg xmlns="http://www.w3.org/2000/svg"
								width="24" height="24" fill="currentColor"
								class="bi bi-box-arrow-in-right" viewBox="0 0 16 16">
			                        <path fill-rule="evenodd"
									d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0z">
			                        </path>
			                        <path fill-rule="evenodd"
									d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708z">
			                        </path>
			                    </svg><br>in
						</a>
					</div>
				</c:when>
				<c:otherwise>
					<div class="link link-right">
						<form action="./loginServlet.do" method="get">

							<button type="submit">
								<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									fill="currentColor" class="bi bi-box-arrow-right"
									viewBox="0 0 16 16">
		                            <path fill-rule="evenodd"
										d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0z" />
		                            <path fill-rule="evenodd"
										d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708z" />
		                        </svg>
								<br>out
							</button>
						</form>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		<hr>
	</header>
</body>
</html>