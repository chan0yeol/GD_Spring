<%@page import="com.min.edu.dto.ProductInfoDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품등록화면</title>
<style type="text/css">
	.field {
	    display: flex;
	    justify-content: center;
	    margin-right: 30px;
	    margin-bottom: 10px;
	}
	.header {
		text-align: center;
		background-color: #FAE0D4;
	}
</style>
</head>
<body>
	<div class="field">
		<button class="btn btn-success btn-lg" type="submit">제품등록</button>
    	<button class="btn btn-danger btn-lg" type="button" onclick="history.back(-1)">등록취소</button>
    </div>
    <form action="./productInsertServlet.do" method="post">
        <div class="container">
            <table>
                <thead class="header">
                    <tr>
                        <th>제품코드</th>
                        <th>이름</th>
                        <th>제조사</th>
                        <th>원가</th>
                        <th>수량</th>
                        <th>승인여부</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><input type="text" name="product_id" placeholder="자동 생성될 제품 코드" readonly></td>
                        <td><input type="text" name="product_name" placeholder="제품 이름을 입력하세요"></td>
                        <td><input type="text" name="product_maker" placeholder="제조사를 입력하세요"></td>
                        <td><input type="text" name="original_cost" placeholder="원가를 입력하세요"></td>
                        <td><input type="text" name="product_amount" placeholder="수량을 입력하세요"></td>
                        <td><input type="checkbox" name="is_accepted" value="true">승인</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </form>
</body>
</html>