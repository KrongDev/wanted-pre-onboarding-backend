# wanted-pre-onboarding-backend
프리온보딩 백엔드 인턴십 선발과제

## [User](./src/main/java/org/example/user/controller/UserController.java)
사용자 관리 서비스

#### 사용자 모델

| column | command           |   
|----------|-------------------|  
| id       | 유저에 할당되는 아이디 (PK) |  
| name     | 유저명               |  

#### 제공 API

| Create User  | 유저 생성                                    |   
|-----------------|---------------------------------------------|  
| Type            | POST                                        |  
| Url             | /user                                       |  
| Request body    | {<br/>&nbsp;&nbsp;&nbsp;"name": "홍길동"<br/>} |  
| Response body   | user_id                                     |  

---

## [Office](./src/main/java/org/example/office/controller/OfficeController.java)
회사 관리 서비스

#### 회사 모델

| column | command           |   
|----------|-------------------|  
| id       | 회사에 할당되는 아이디 (PK) |  
| name     | 회사명               |  
| nation   | 국가명               |  
| region   | 도시명               |  

#### 제공 API

| Create Office  | 회사 생성                                                                                                                    |   
|-------------------|-----------------------------------------------------------------------------------------------------------------------------|  
| Type              | POST                                                                                                                        |  
| Url               | /office                                                                                                                     |  
| Request body      | {<br/>&nbsp;&nbsp;&nbsp;"name": "홍길동",<br/> &nbsp;&nbsp;&nbsp;"nation": "대한민국",<br/> &nbsp;&nbsp;&nbsp;"region": "서울"<br/>} |  
| Response body     | office_id                                                                                                                   |  

---

## [Job Post](./src/main/java/org/example/jobPost/controller/JobPostController.java)

채용공고 관리 서비스

#### 채용공고 모델

| column     | command             |   
|--------------|---------------------|  
| id           | 채용공고에 할당되는 아이디 (PK) |  
| officeId     | 회사아이디               |  
| officeName   | 회사명                 |  
| nation       | 국가명                 |  
| region       | 도시명                 |  
| position     | 채용포지션               |  
| compensation | 채용보상금               |  
| content      | 채용내용                |  
| skill        | 채용기술                |  

#### 제공 API

| Create Job Post  | 채용공고 생성                                                                                                                                                                                                                                    |   
|---------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|  
| Type                | POST                                                                                                                                                                                                                                          |  
| Url                 | /job-post                                                                                                                                                                                                                                     |  
| Request body        | {<br/>&nbsp;&nbsp;&nbsp;"officeId": "1234",<br/> &nbsp;&nbsp;&nbsp;"position": "Java개발자",<br/> &nbsp;&nbsp;&nbsp;"compensation": 100000,<br/> &nbsp;&nbsp;&nbsp;"content": "네이버에서 채용중인 포지션은...",<br/> &nbsp;&nbsp;&nbsp;"skill": "Java"<br/>} |  
| Response body       | job_post_id                                                                                                                                                                                                                                   |  

| Update Job Post  | 채용공고 수정                                                                                                                                                                                          |   
|---------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|  
| Type                | PUT                                                                                                                                                                                                 |  
| Url                 | /job-post/{채용공고 아이디}                                                                                                                                                                                |  
| Request body        | {<br/> &nbsp;&nbsp;&nbsp;"position": "Java개발자",<br/> &nbsp;&nbsp;&nbsp;"compensation": 100000,<br/> &nbsp;&nbsp;&nbsp;"content": "네이버에서 채용중인 포지션은...",<br/> &nbsp;&nbsp;&nbsp;"skill": "Java"<br/>} |  
| Response body       | 없음                                                                                                                                                                                                  |  

| Delete Job Post  | 채용공고 삭제           |   
|---------------------|----------------------|  
| Type                | DELETE               |  
| Url                 | /job-post/{채용공고 아이디} |  
| Request body        | 없음                   |  
| Response body       | 없음                   |

| Query Job Posts  | 채용공고 목록 조회                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |   
|---------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|  
| Type                | GET                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |  
| Url                 | /job-post                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |  
| Request body        | 없음                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |  
| Response body       | [<br/> &nbsp;&nbsp;&nbsp;{<br/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"jobPostId": "1234",<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"officeId": "1234",<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"officeName": "네이버",<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"nation": "대한민국",<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"region": "서울",<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"position": "Java 개발자",<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"compensation": 1000000,<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"content": "..."<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"skill": "Java"<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"officePostIds": null <br/>&nbsp;&nbsp;&nbsp;} <br/>] |  

| Search Job Posts | 채용공고 목록 검색 조회 (회사명, 체용포지션으로 검색 가능) Example 1, 2 기준 구현                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |   
|------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|  
| Type             | GET                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |  
| Url              | /job-post?search={검색값}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |  
| Request body     | 없음                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |  
| Response body    | [<br/> &nbsp;&nbsp;&nbsp;{<br/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"jobPostId": "1234",<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"officeId": "1234",<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"officeName": "네이버",<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"nation": "대한민국",<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"region": "서울",<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"position": "Java 개발자",<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"compensation": 1000000,<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"content": "..."<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"skill": "Java"<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"officePostIds": null <br/>&nbsp;&nbsp;&nbsp;} <br/>] |  

| Query Job Post | 채용공고 상세 조회                                                                                                                                                                                                                                                                                                                                                                                                                                              |   
|----------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|  
| Type           | GET                                                                                                                                                                                                                                                                                                                                                                                                                                                     |  
| Url            | /job-post/{채용공고 아이디}                                                                                                                                                                                                                                                                                                                                                                                                                                    |  
| Request body   | 없음                                                                                                                                                                                                                                                                                                                                                                                                                                                      |  
| Response body  | {<br/> &nbsp;&nbsp;&nbsp;"jobPostId": "1234",<br/>&nbsp;&nbsp;&nbsp;"officeId": "1234",<br/>&nbsp;&nbsp;&nbsp;"officeName": "네이버",<br/>&nbsp;&nbsp;&nbsp;"nation": "대한민국",<br/>&nbsp;&nbsp;&nbsp;"region": "서울",<br/>&nbsp;&nbsp;&nbsp;"position": "Java 개발자",<br/>&nbsp;&nbsp;&nbsp;"compensation": 1000000,<br/>&nbsp;&nbsp;&nbsp;"content": "..."<br/>&nbsp;&nbsp;&nbsp;"skill": "Java"<br/>&nbsp;&nbsp;&nbsp;"officePostIds": ["111", "222"] <br/>} |  

| Apply Job Post | 채용공고 지원                                                                                   |   
|----------------|-------------------------------------------------------------------------------------------|  
| Type           | Post                                                                                      |  
| Url            | /job-post/apply                                                                           |  
| Request body   | {<br/>&nbsp;&nbsp;&nbsp;"jobPostId": "1234",<br/>&nbsp;&nbsp;&nbsp;"userId": "1234"<br/>} |  
| Response body  | 없음                                                                                        |  

### Office Post Map

채용공고 주체 회사 관리 서비스

한 회사에서 채용공고 시 평균적으로 10개기준으로 판단하여 하나의 컬럼에서 관리

#### 채용공고 주체 회사 관리 모델

| column     | command            |   
|------------|--------------------|  
| officeId   | 회사 아이디 (PK)        |  
| jobPostIds | 회사에서 공고한 채용공고 아이디들 | 

### Post User Map

채용공고 지원자 관리 서비스

하나의 채용공고에 많은 유저가 지원할 수 있도록 모델 설계

#### 채용공고 지원자 관리 모델

| column    | command       |   
|-----------|---------------|  
| jobPostId | 채용공고 아이디 (PK) |  
| userId    | 지원자 아이디 (PK)  | 
