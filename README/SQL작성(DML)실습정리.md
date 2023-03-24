## SQL 작성하기(DML)

### 아래 QUERY문으로 테이블을 생성하고 데이터를 입력하시오.

DROP TABLE IF EXISTS BACKPACK ;         
CREATE TABLE BACKPACK (         
  ID SERIAL PRIMARY KEY           
, BOOK VARCHAR(50) NOT NULL             
);          

INSERT INTO BACKPACK(BOOK) VALUES('SPRING');            
INSERT INTO BACKPACK(BOOK) VALUES('SPRING');              
INSERT INTO BACKPACK(BOOK) VALUES('JAVASCRIPT');              
INSERT INTO BACKPACK(BOOK) VALUES('JAVASCRIPT');              
INSERT INTO BACKPACK(BOOK) VALUES('JAVASCRIPT');              
INSERT INTO BACKPACK(BOOK) VALUES('CSS');
            
COMMIT;             
              
SELECT * FROM BACKPACK;    

![image](https://user-images.githubusercontent.com/122864238/227412225-d051e254-2fca-495e-b2e2-4885ff5d3dad.png)

![image](https://user-images.githubusercontent.com/122864238/227412275-66f400ae-6674-4599-97aa-5e96c73be843.png)



### BACKPACK 테이블에서 BOOK 컬럼이 중복된 행을 삭제하시오.(QUERY문에 ROW_NUMBER() 함수를 사용하고 DELETE문을 작성하여 ID 순번이 높은 것을 삭제하시오)
- delete 문을 이용하여 where절에저 서브쿼리를 사용하였다.         
- where의 서브쿼리의 select절에서 row_number를 가져와도 from과 where에서는 사용할 수 없으므로 
 from절에 인라인 뷰 서브쿼리를 하나 더 만들어 row_number를 사용하여 where절에서 사용할 수 있도록 해주었다.              
- 인라인뷰의 select를 통해 불러온 테이블 퀄럼은 메인쿼리에서도 가져올 수 있다.         

![image](https://user-images.githubusercontent.com/122864238/227412613-9db8d541-e078-49b0-b728-b2d9ab9be620.png)

![image](https://user-images.githubusercontent.com/122864238/227412355-2b8c886b-ce9b-44c0-9a82-cc124db74a3d.png)
  
