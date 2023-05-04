## 해야할 과제         
- 게시판글 목록 조회 화면을 구현(로그인 후 조회 가능) 
- 스프링 MVC 프레임워크 및 DI(Dependency Injection)을 사용하고 데이터베이스 연동
- 자바 파일은 패키지 분리(controller, service, dao, domain)
- 자바 퍼시스턴스 프레임워크인 Mybatis를 사용

## Mybatis를 사용하기 위해 준비해야 할 것        
### pom.xml       
- dependency 추가하기       

![image](https://user-images.githubusercontent.com/122864238/236132251-2d437b94-f1e3-4ea6-a7e0-cbe24957d56c.png)

### root-context.xml        
- dataSource, sqlSessionFactory, sqlSession 빈 생성해주기       
- 빈 사용을 위한 component-scan도 설정해주기

![image](https://user-images.githubusercontent.com/122864238/236132799-aa5b31c9-17cb-4369-949f-01a02afd35a3.png)

### servlet-context.xml       
- component-scan 설정해주고 HomeController 없이도 home으로 이동시켜줄 수 있는 view-controller를 넣어주었다.

![image](https://user-images.githubusercontent.com/122864238/236136407-ff23149e-1de0-4bfa-9633-71b0da1c02c0.png)

### BoardDTO 생성     
- 테이블의 속성을 기반으로 클래스를 생성해준다.
- 모든 변수는 private로 지정해주고, hashcode()와 equals()를 이용하여 논리적 동등성을 구별할 수 있도록 해준다.
- 변수를 private로 지정해주었기 때문에 getter/setter를 설정해준다.
- 필요에 따라 toString()도 오버라이드해준다.

![image](https://user-images.githubusercontent.com/122864238/236137528-8d6a675b-6467-4a20-ab4e-8b2771d43d31.png)


### mapper와 config 생성     
- config는 xml파일 하나만 생성해야 한다.
- config에는 사용하는 configration을 입력해주고 mapper에는 사용할 쿼리문을 입력해준다.
- !DOCTYPE은 MyBatis 홈페이지에서 가져왔다.

![image](https://user-images.githubusercontent.com/122864238/236138387-3d701df5-bc99-4f9f-b96f-53580d70b2b0.png)

## DAO(Repository)       
Dao를 생성할 때 나중에 수정하기 쉽게하기 위해서 interface를 만들어 사용한다.
### BoardDao(Interface)
게시판 사용시 사용할 쿼리문을 생각해서 메서드 이름을 붙여주었다.
- selectPage: page별로 불러올 BoardDTO 데이터들(limit와 offset 필요)
- insert: 게시글 작성시 BoardDTO가 DB에 들어가게 된다.
- count: 게시글 페이지에서 게시글을 page마다 paging하여 불러올 때 게시글의 총 수를 알아야한다.

![image](https://user-images.githubusercontent.com/122864238/236138832-b20090ff-4c12-4136-b752-423d0bc2341b.png)

### BoardDaoImpl
- @Repository 어노테이션을 꼭 붙여주어야한다.
- root-context.xml에 추가해둔 sqlSession 빈을 사용하기 위해 @Autowired를 사용하여 가져와준다.
- 인터페이스에서 만들어둔 메서드들을 오버라이드 해준 후 쿼리문은 mapper에 작성해준다.
- MyBatis 덕분에 쿼리문은 따로 작성할 수 있고 쿼리문의 id에 따라 불러올 수 있다.

![image](https://user-images.githubusercontent.com/122864238/236139938-6b180565-8a59-40d8-a114-139b4b3caa23.png)


### Mapper        
- mapper마다 namespace를 정해두어 같은 다른 테이블(다른 DTO)의 select라도 구분할 수 있도록 해준다.
- 쿼리문마다 id를 주어 같은 테이블(같은 DTO)의 같은 select라도 다를 수 있는 내용을 구분해준다.
- 이때 Dao 메서드 설정시 받는 매개변수타입(parameterType)과 리턴타입(resultType)을 꼭 써주어야 한다.

![image](https://user-images.githubusercontent.com/122864238/236140894-1f86ccf4-b355-45e0-b050-68d23509eb9b.png)

## Service          
나중에 유지보수를 용이하게 하기 위해 관심사를 분리하기 위해 Repository와 Service, Controller등 관심사를 모두 분리해둔다.       
Service도 Dao와 마찬가지로 interface를 만들어 사용한다.

![image](https://user-images.githubusercontent.com/122864238/236141873-7aa8af3a-86bd-49bc-87fe-06216bde03d8.png)

### BoardService          
Dao에서 만든 DB방식의 이름으로 만들어진 메서드들을 business logic 방식으로 해서 만들어준다.

![image](https://user-images.githubusercontent.com/122864238/236145509-7df3d6b1-ea41-48c9-8224-caaa4ce262e2.png)


### BoardServiceImpl        
SearchItem에 pageSize와 page 모두 있기 때문에 SearchItem을 넘겨주었다.

![image](https://user-images.githubusercontent.com/122864238/236145682-ea2e7bd2-35df-49e9-b60c-a5eeb7374de4.png)

## Domain       
### SearchItem
- 매개변수로 page와 pageSize를 받고 option과 keyword가 없을시 공백으로 지정해주었다(검색하지 않고 들어갈때는 아무것도 없어야함)
- 경우의 수에 따라 생성자를 나누어 만들어주었다.
- 뒤로가기를 누르더라도 보던 게시판 page로 넘어가도록 해주기 위해 게시물에 들어갈 때 page, pageSize 등을 QueryString으로 넘겨주었다.
- 페이지마다 쿼리문에 들어갈 offset도 일반화해주었다.

![image](https://user-images.githubusercontent.com/122864238/236148901-80cbe24c-8979-4edb-b47c-84762aa808c1.png)

### PageResolver        
- 전체 게시물 개수에 따른 전체 페이지 수를 일반화해주었다.
- 페이지 번호에 따른 시작페이지(beginPage)와 끝페이지(endPage)도 일반화 해준 후 이전으로 갈지 다음으로 갈지에 대한 화살표가 나타날 시기도 정해주었다.

![image](https://user-images.githubusercontent.com/122864238/236146996-0e84a9d8-0b7b-47c8-930b-296d789247f6.png)

## Controller     
### BoardController
자유 게시판을 클릭했을 때 session을 확인하여 저장된 session이 없다면 로그인 화면으로 이동후 로그인 완료된 뒤 자유게시판으로 이동하게 하였다.
전체 게시글의 수를 확인한 후 model에 전체 게시물의 수를 저장해주었다.          
totalCnt와 SearchItem을 포함하고 있는 PageResolver를 생성하여준다.       
그리고 게시글들을 Service를 이용하여 DAO의 selectList를 호출하였다. 이때 page와 pageSize를 가지고 있는 SearchItem을 매개변수로 넣어주었다. 
model에 list와 PageResolver를 model에 저장해주었다.       

![image](https://user-images.githubusercontent.com/122864238/236153024-a7b7613a-bdc0-4a02-b06e-a917930811bf.png)


## JSP    
![image](https://user-images.githubusercontent.com/122864238/236153981-73b68fbb-c558-47f4-bc43-46dad87674df.png)

## TEST를 이용한 INSERT       

![image](https://user-images.githubusercontent.com/122864238/236154394-9a1b4bf3-d55b-4833-b07a-6c603d9036a8.png)



## 구현 결과
### HOME 화면
- 로그인 전

![image](https://user-images.githubusercontent.com/122864238/236154536-0d5f5d0e-333a-430f-bee5-c9b09cf2a457.png)

- 로그인 후

### 자유게시판
- 로그인 전

![image](https://user-images.githubusercontent.com/122864238/236154628-87f5c986-9367-4906-b8be-2d3a876f2ef8.png)

-로그인 후

![image](https://user-images.githubusercontent.com/122864238/236154726-fbee4f0c-7c09-45ab-9639-3103d29f0e2b.png)

### 글
- 글 없을 때

![image](https://user-images.githubusercontent.com/122864238/236156138-cc1fd606-7b2c-4317-b646-e9b0b9b83444.png)

- 글 있을 때

![image](https://user-images.githubusercontent.com/122864238/236154736-a727eed6-fc48-47c3-89ce-84b7f2e934d4.png)







