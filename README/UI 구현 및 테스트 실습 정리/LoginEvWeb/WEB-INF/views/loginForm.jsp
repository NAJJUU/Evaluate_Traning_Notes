<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LOGIN 페이지</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/loginForm.css" />
    
</head>
<body>
    
     <form action='<c:url value='/loginForm' />' method="post">
    	<div class="wrap">
    		<div class="login">LOGIN</div>
    		<div class="id-pwd">
    			<div>
		    		<label>아이디</label>
		    		<input type="text" name="id" autofocus="autofocus" placeholder="ID를 입력해주세요"/>
		    	</div>
		    	<div>
		    		<label>비밀번호</label>
		    		<input type="password" name="pwd" placeholder="PASSWORD를 입력해주세요"/>
		    	</div>    		
    		</div>

    		<button>login</button>
    	</div>
    	
    </form>
    
</body>
</html>



