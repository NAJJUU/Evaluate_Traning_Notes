<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="loginout" value="${sessionScope.id==null ? 'Login' : 'Logout' }" />
<c:set var="loginoutlink" value="${sessionScope.id==null ? '/loginForm' : '/logout' }"/>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메인화면</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/index.css" />
</head>
<body>
    <div class="wrap">
    	<div class="main">SCREEN</div>    	
    	<div class="cat">
    		<div>
    		<c:if test="${sessionScope.id==null}">
    			<a href="<c:url value='/board' />">자유게시판</a>
    			<a href="<c:url value='${loginoutlink }' />">${loginout}</a>
    			<a href="<c:url value='/register' />">Register</a>    		
    		</c:if>  		
    		<c:if test="${sessionScope.id!=null}">
    			<div style="font-size: 35px;">환영합니다! ${sessionScope.id }님♡</div>
    			<a href="<c:url value='/board' />">자유게시판</a>
    			<a href="<c:url value='${loginoutlink }' />">${loginout}</a>		
    		</c:if>
    		</div>
    	</div>
    	<img alt="시네마타임" src="./resources/img/시네마타임.png">
    </div>
</body>
</html>





