## 사용자 로그인 화면 및 로그인 후 메인 화면을 구현하시오.
- 쿠키 및 세션 객체 생성하여 id 저장
- 로그인 / 로그아웃 기능 구현

### HomeControlloer.java            
HomeControlloer에 main 화면인 index.jsp를 연결해 두었다.       

![image](https://user-images.githubusercontent.com/122864238/233533342-16e6d842-2d27-4741-a57e-4341f8c095d1.png)

### LoginController.java        
각각의 jsp를 Controller에 연결해주고 로그인시 로그인 버튼을 누를 때 발생하는 이벤트들을 설정해주었다.     
- 로그인이 실행되는 조건(값이 입력만 되어 있으면 로그인이 되도록 설정해둠)
- 로그인이 되면 응답헤더 쿠키를 생성하고 로그인 시 id값을 쿠키에 저장함
- 세션을 만들어주고 세션에 값을 넣어줌
- 로그 아웃 시 세션을 제거해줌

![image](https://user-images.githubusercontent.com/122864238/233536392-9b2b0153-bb4e-41fa-bb00-3cc9ec93e728.png)


### loginForm.jsp 
![image](https://user-images.githubusercontent.com/122864238/233550163-dd8dcb21-0500-4806-b6f6-c3d9693d030f.png)


### index.jsp
![image](https://user-images.githubusercontent.com/122864238/233551683-8352927d-7866-4b5b-886d-e70029827e32.png)

### 구현 화면     
#### 로그인 전 홈 화면         
Login 표시로 되어있다.            
![image](https://user-images.githubusercontent.com/122864238/233553418-41f448dc-385f-432c-8e08-82cf1bc783cd.png)


#### 로그인 화면       
로그인이 성공하면 쿠키가 id이름으로 생성된다.          
![image](https://user-images.githubusercontent.com/122864238/233553509-f948a191-e6c7-4342-be7b-d8d98c17c108.png)


#### 로그인 후 홈 화면           
로그인을 하고 나면 Login부분이 Logout으로 바뀐다.     
![image](https://user-images.githubusercontent.com/122864238/233553574-b2d4afd5-e463-4cc3-b1d3-4511a94f8e44.png)


## 스프링에서의 예외처리 컨트롤러 및 예외처리 화면을 구현하시오.
- 전역의 예외 처리 클래스 구현 
- 에러 페이지 구현

### web.xml
![image](https://user-images.githubusercontent.com/122864238/233552355-0e179dc7-3b0c-4dab-acf0-5f8e586cd41e.png)

### error400.jsp, error500.jsp
![image](https://user-images.githubusercontent.com/122864238/233552413-b23c17b2-a6f6-4e7c-ba22-532bbeafd8a0.png)
![image](https://user-images.githubusercontent.com/122864238/233552422-6abc7c6d-a384-4f76-87bd-fd450eb4f6be.png)


### SharedExceptionController.java

![image](https://user-images.githubusercontent.com/122864238/233553183-a8a3c003-a0e0-4064-aeca-8d7f3abcc10e.png)


### error400, error500 구현화면       
![image](https://user-images.githubusercontent.com/122864238/233553725-7f721882-d4a9-4427-854f-02dd7302063a.png)
![image](https://user-images.githubusercontent.com/122864238/233553734-a74f290c-8d73-48ba-88a4-cd4a4975f869.png)




