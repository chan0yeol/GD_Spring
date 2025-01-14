<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="./header.jsp" %>
</head>
<body>
	<%
// 		Object obj = request.getAttribute("fail");
// 		String fail = (String) obj;
	%>
    	<h1>
    		<c:if test="${fail eq null }">
    			${fail}
    		</c:if>
    	</h1>
        <main class="form-signin w-100 m-auto">
            <div class="container">
                <form action="./loginServlet.do" method="post">
                    <h1 class="h3 mb-3 fw-normal">Login</h1>
    
                    <div class="form-floating mb-1" >
                        <input type="text" name="ename" class="form-control" id="floatingInput" placeholder="이름">
                        <label for="floatingInput">이름</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="password" name="empno" class="form-control" id="floatingPassword" placeholder="사원번호">
                        <label for="floatingPassword">사원번호</label>
                    </div>
    
                    <button class="btn btn-primary w-100 py-2" type="submit">Login</button>
                </form>
            </div>
        </main>
</body>
</html>