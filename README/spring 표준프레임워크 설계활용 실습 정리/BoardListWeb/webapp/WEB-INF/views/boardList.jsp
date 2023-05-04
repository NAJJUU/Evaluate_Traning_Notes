<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="loginout" value="${sessionScope.id==null ? 'Login' : 'Logout' }" />
<c:set var="loginoutlink" value="${sessionScope.id==null ? '/loginForm' : '/logout' }"/>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/index.css" />
    <title>자유 게시판</title>
    
    <style type="text/css">
    	.board-container{
    		width: 60%;
    		height: 1200px;
    		margin: 0 auto;
    	}
    	
    	table{
    		border-collapse: collapse;
    		width: 100%;
    		border-top: 2px solid #202020;
    		margin-top: 20px;
    	}
		
		.paging-container{
			width: 100%;
			height: 70px;
			display: flex;
			margin-top: 50px;
			margin: auto;
			text-align: center;
		}
		
		.paging{
			color: #fff;
			width: 100%;
			align-items: center;
			margin: 10px 0;
		}
		
		.page{
			color: #fff;
			padding: 6px;
			margin-right: 10px;
		}
		
		a{
			color: #fff;
		}
		
		tr{
			font-size: 20px;
		}
		
		th, td{
			width: 300px;
			text-align: center;
			padding: 10px 12px;
			border-bottom: 1px solid #646464;
		}

    </style>
</head>
<body>
    <div class="wrap">
    	<div class="main">SCREEN</div>    	
    	<div class="cat">
    		<div> 		
    		<c:if test="${sessionScope.id!=null}">
    			<div style="font-size: 35px;">환영합니다! ${sessionScope.id }님♡</div>
    			<a href="<c:url value='/' />">HOME</a>
    			<a href="<c:url value='${loginoutlink }' />">${loginout}</a>		
    		</c:if>
    		</div>
    	</div>	
	<div>

	</div>
	
	<div style="align-items: center;">
    	<div class="board-container">    		
    		<table>
    			<tr>
    				<th class="no">번호</th>
    				<th class="title">제목</th>
    				<th class="writer">이름</th>
    				<th class="regdate">등록일</th>
    				<th class="viewcnt">조회수</th>
    			</tr>

    			<c:forEach var="boardDTO" items="${list}">
    				<tr>
    					<td class="no">${boardDTO.bno }</td>
    					<td class="title">${boardDTO.title}</td>
    					<td class="writer">${boardDTO.writer}</td>
    					<td class="regdate">
    						<fmt:formatDate value="${boardDTO.reg_date }" pattern="yyyy-MM-dd" type="date" />
    					</td>
    					<td class="viewcnt">${boardDTO.view_cnt}</td>
    				</tr>
    			</c:forEach>
    		</table>
    		<br>
    		
    		<div class="paging-container">
    			<div class="paging">
    				<c:if test="${totalCnt == null || totalCnt == 0}">
    					<div>게시물이 없습니다.</div>
    				</c:if>
    				<c:if test="${totalCnt != null || totalCnt != 0}">
    					<c:if test="${pr.showPrev}">
    						<%-- <a class="page" href="<c:url value="/board/list${pr.sc.getQueryString(((pr.sc.page-1)/10-1)*10+1)}" />">&lt;</a> --%>
    						<a class="page" href="<c:url value="/board${pr.sc.getQueryString(pr.beginPage-1)}" />">&lt;</a>
    					</c:if>
    					<c:forEach var="i" begin="${pr.beginPage }" end="${pr.endPage}">
    						<a class="page" href="<c:url value="/board${pr.sc.getQueryString(i)}" />">${i}</a>
    					</c:forEach>
    					<c:if test="${pr.showNext}">
    						<%-- <a class="page" href="<c:url value="/board/list${pr.sc.getQueryString(((pr.sc.page-1)/10+1)*10+1)}" />">&gt;</a> --%>
    						<a class="page" href="<c:url value="/board${pr.sc.getQueryString(pr.endPage+1)}" />">&gt;</a>
    					</c:if>
    				</c:if>
    			</div>
    		</div> 		
    	</div>	
	</div>
	
	</div>
</body>
</html>