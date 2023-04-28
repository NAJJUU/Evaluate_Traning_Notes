<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
     <form:form modelAttribute="user" onsubmit="return formCheck(this)">
    	<div class="wrap">
    		<div class="login">Register</div>
    		<div class="id-pwd">
    			<div id="msg"></div>
    			<div>
		    		<label>이름</label>
		    		<input type="text" name="name" placeholder="이름을 입력해주세요"/>
		    	</div>  
    			<div>
		    		<label>아이디</label>
		    		<input type="text" name="id" autofocus="autofocus" placeholder="ID를 입력해주세요"/>
		    	</div>
		    	<div>
		    		<label>비밀번호</label>
		    		<input type="password" name="pwd" placeholder="PASSWORD를 입력해주세요"/>
		    	</div>    	 
		    	<div>
		    		<label>이메일</label>
		    		<input type="text" name="email" placeholder="이메일을 입력해주세요"/>
		    	</div>  	
    		</div>
    		<button>register</button>
    	</div>
    </form:form>    
    <script type="text/javascript">
    	function formCheck(frm) {
			let msg = ''			
			if(frm.id.value.length < 8){
				setMessage('id의 길이는 8자 이상어야합니다.', frm.id);
				return false;
			}
			if(frm.pwd.value.length < 8){
				setMessage('비밀번호의 길이는 8자 이상어야합니다.', frm.pwd);
				return false;
			}						
			if(frm.name.value==null){
				setMessage('이름은 필수 입력값입니다.', frm.name);
				return false;
			}
			if(frm.email.value.length < 10){
				setMessage('옳바른 이메일을 입력해주세요.', frm.email);
				return false;
			}
			return true;
		}        	
    	function setMessage(msg, element) {
			document.getElementById("msg").innerHTML = `<i class="fa fa-exclamation-circle">${'${msg}'}</i>`
			if(element){
				element.select()		//값을 잘못 입력되었을 때 그 요소를 선택되게함
			}
		}
    </script>
</body>
</html>
