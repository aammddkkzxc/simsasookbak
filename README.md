# 🏡 simsasookbak!🏡
### 지나가는 나그네여! 쉬었다가시오! 심사숙박!


<br></br>
## 1️⃣  프로젝트 설명

### 심사숙박

> '심사숙박'은 야놀자, 호텔스컴바인과 같은 서비스를 모델로 삼아, 여행자들이 숙박 시설에 대한 정보를 얻고 예약 및 리뷰를 남길 수 있는 플랫폼입니다.   
> 🌊 심사숙박만의 차별화된 기능인 Allen API를 활용한 내부 커뮤니티를 통한 리뷰 요약, 타 사이트의 해당 숙박 시설에 대한 리뷰 요약을 확인하실 수 있습니다.




<br></br>
## 2️⃣ 팀원 소개 
이영석(PL)  
김상형  
박지은  
송찬혁  
정민석  
최보현  

<br></br>
## 3️⃣ 프로젝트 사용 기술 및 환경

FE

- HTML
- CSS
- BootStrap
- Thymeleaf

BE 

- SpringBoot
- Java

DB

- MySQL

환경

- AWS
- Intellij
- Github
- Discord + 웹훅을 통한 깃헙 알림 설정

<br></br>
## 4️⃣ 개발 일정  
![image](https://github.com/teamSeven71/TechTalk/assets/109260733/79041981-d030-4cc8-b833-087445a07fee)

<br></br>
## 5️⃣ User Flow

① 플랫폼의 가장 첫 페이지인 메인페이지를 기준으로 Flow를 나누어 작성하였습니다.   <br></br>
② 노란색은 페이지를 보라색은 이동 버튼 및 트리거를 의미하며, 다이아몬드 모형은 논리 로직을 의미합니다.    <br></br>
③ 빨간색 화살표는 비회원도 접근이 가능합니다. 파란색 화살표는 일반 유저의 로그인 상태일 경우, 초록색 화살표의 경우에는 숙박업자가 로그인한 상태에 접근 가능합니다.   <br></br> 
④ 메인페이지에서 로그인페이지 이동, 검색을 통한 숙소목록페이지 이동, 마이페이지 및 숙소 찾기 페이지로 등으로의 이동이 가능며, 공통적으로 모든 페이지에서 로그아웃이 가능합니다.  <br></br>

![image](https://github.com/anonymousOrmi/simsasookbak/assets/109260733/40d182bd-e826-4e33-b464-d056792eb734)



<br></br>
## 6️⃣ 요구사항 및 기능 명세  
![image](https://github.com/teamSeven71/TechTalk/assets/109260733/8759b35e-0b31-47c7-8407-6ad7dc1e8f91)

<br></br>
## 7️⃣ 데이터베이스 모델링(ERD)  

① 크게 회원테이블, 숙소테이블, 리뷰테이블, 예약 내역테이블, 유튜브테이블로 나누었습니다.    
② 숙소 / 숙소 서비스, 객실 / 객실 서비스 테이블 간 중간 테이블을 두어 매핑하였습니다.   
③ 이미지가 필요한 테이블은 첨부파일 테이블을 별도로 두어 관리하였습니다.

![image](https://github.com/anonymousOrmi/simsasookbak/assets/109260733/4e9235b1-32ed-42df-8864-e6251c1557d8)

<br></br>
##  배포 아키텍처  

사용자가 URL을 통해 ec2 인스턴스에 빌드된 스프링부트 서버에 접속요청을 보내면, 
서버는 RDS에 있는 MySQL DB에 메인 페이지의 thymeleaf에서 필요한 공지사항, 카테고리 종류 데이터를 요청하고, HTML,CSS(Bootstrap),JS를 구성해 사용자에게 요청한 View를 반환해줍니다.  
IntelliJ에서 작업한 작업내용은 Github Repo에 저장하며, commit, merge, pr 등 레포지토리에서 발생하는 모든 변화는 디스코드 웹훅을 통해 즉시 알림메세지 형태로 전달됩니다.
![image](https://github.com/teamSeven71/TechTalk/assets/109260733/0c6b9539-d7ac-4223-a1d2-a4c6e2a521ab)

<br></br>
##  API 명세서

➰ :  표시 중 최소 1개 필요

✔️ :  체크 표시만 가능

![image](https://github.com/teamSeven71/TechTalk/assets/109260733/cf2025c4-e728-4be9-84dc-c5569c145213)

![image](https://github.com/teamSeven71/TechTalk/assets/109260733/8fe72f45-8c90-4d27-b30b-ed7b165985c4)

<br></br>
##  프로젝트 구조
### FE + BE

📂 gradle  
📂 src  
┣ 📂 main  
┃ ┗ 📂 java  
┃ ┃ ┗ 📂 com   
┃ ┃ ┃ ┗ 📂 simsasookbak    
┃ ┃ ┃ ┃ ┗ 📂 accommodation     
┃ ┃ ┃ ┃ ┃ ┗ 📂 controller   
┃ ┃ ┃ ┃ ┃ ┗ 📂 domain    
┃ ┃ ┃ ┃ ┃ ┗ 📂 dto   
┃ ┃ ┃ ┃ ┗ 📂 email   
┃ ┃ ┃ ┃ ┃ ┗ 📂 domain   
┃ ┃ ┃ ┃ ┃ ┗ 📂 dto   
┃ ┃ ┃ ┃ ┃ ┗ 📂 service   
┃ ┃ ┃ ┃ ┗ 📂 external   
┃ ┃ ┃ ┃ ┃ ┗ 📂 ai    
┃ ┃ ┃ ┃ ┃ ┗ 📂 youtube   
┃ ┃ ┃ ┃ ┗ 📂 global   
┃ ┃ ┃ ┃ ┃ ┗ 📂 aop   
┃ ┃ ┃ ┃ ┃ ┗ 📂 config   
┃ ┃ ┃ ┃ ┃ ┗ 📂 exception   
┃ ┃ ┃ ┃ ┃ ┗ 📂 page     
┃ ┃ ┃ ┃ ┃ ┗ 📂 util     
┃ ┃ ┃ ┃ ┃ ┃ 📜 BaseEntity.class     
┃ ┃ ┃ ┃ ┗ 📂 member     
┃ ┃ ┃ ┃ ┃ ┗ 📂 controller     
┃ ┃ ┃ ┃ ┃ ┗ 📂 domain   
┃ ┃ ┃ ┃ ┃ ┗ 📂 dto   
┃ ┃ ┃ ┃ ┃ ┗ 📂 repository    
┃ ┃ ┃ ┃ ┃ ┗ 📂 service   
┃ ┃ ┃ ┃ ┗ 📂 reservation  
┃ ┃ ┃ ┃ ┃ ┗ 📂 controller   
┃ ┃ ┃ ┃ ┃ ┗ 📂 domain   
┃ ┃ ┃ ┃ ┃ ┗ 📂 dto    
┃ ┃ ┃ ┃ ┃ ┗ 📂 repository   
┃ ┃ ┃ ┃ ┃ ┗ 📂 service    
┃ ┃ ┃ ┃ ┃ ┗ 📂 scheduling    
┃ ┃ ┃ ┃ ┗ 📂 review    
┃ ┃ ┃ ┃ ┃ ┗ 📂 controller   
┃ ┃ ┃ ┃ ┃ ┗ 📂 domain    
┃ ┃ ┃ ┃ ┃ ┗ 📂 dto   
┃ ┃ ┃ ┃ ┃ ┗ 📂 repository    
┃ ┃ ┃ ┃ ┃ ┗ 📂 service       
┃ ┃ ┃ ┃ ┗ 📂 room    
┃ ┃ ┃ ┃ ┃ ┗ 📂 controller   
┃ ┃ ┃ ┃ ┃ ┗ 📂 domain      
┃ ┃ ┃ ┃ ┃ ┗ 📂 dto   
┃ ┃ ┃ ┃ ┃ ┗ 📂 repository   
┃ ┃ ┃ ┃ ┃ ┗ 📂 service     
┃ ┗ 📂 resources    
┃ ┃ ┗ 📂 static     
┃ ┃ ┃ ┗ 📂 css    
┃ ┃ ┃ ┃ ┗ 📜 adminPage.css    
┃ ┃ ┃ ┃ ┗ 📜 bootstrap.min.css    
┃ ┃ ┃ ┃ ┗ 📜 index.css    
┃ ┃ ┃ ┃ ┗ 📜 register.css    
┃ ┃ ┃ ┃ ┗ 📜 reservationForm.css    
┃ ┃ ┃ ┃ ┗ 📜 style.css    
┃ ┃ ┃ ┃ ┗ 📜 table.css     
┃ ┃ ┃ ┃ ┗ 📜 templatemo-topic-listing.css    
┃ ┃ ┗ 📂 img   
┃ ┃ ┗ 📂 js    
┃ ┃ ┃ ┗ 📜 adminPage.js      
┃ ┃ ┃ ┗ 📜 index.css    
┃ ┃ ┃ ┗ 📜 register.css    
┃ ┃ ┃ ┗ 📜 mypage.js  
┃ ┃ ┃ ┗ 📜 popularRegion.js    
┃ ┃ ┃ ┗ 📜 main.js     
┃ ┃ ┃ ┗ 📜 review.js     
┃ ┃ ┃ ┗ 📜 reservationList.js    
┃ ┃ ┃ ┗ 📜 updateReservation.js     
┃ ┗ 📂 templates       
┃ ┃ ┗ 📂 layout    
┃ ┃ ┗ 📜 accommodation-register.html      
┃ ┃ ┗ 📜 accommodation-update..html         
┃ ┃ ┗ 📜 adminPage.html      
┃ ┃ ┗ 📜 details.html      
┃ ┃ ┗ 📜 index.html     
┃ ┃ ┗ 📜 list-page.html      
┃ ┃ ┗ 📜 login.html      
┃ ┃ ┗ 📜 my-accommodation-list.html      
┃ ┃ ┗ 📜 my-reservation-list.html     
┃ ┃ ┗ 📜 mypageInfo.html     
┃ ┃ ┗ 📜 reservation-management.html        
┃ ┃ ┗ 📜 review-register.html        
┃ ┃ ┗ 📜 room-update.html     
┃ ┃ ┗ 📜 updateReservationPage.html    
┗ 📂 test  
┣ 📜 gradlew    
┣ 📜 gradlew.bat    
┣ 📜 README.md    
┣ 📜 settings.gradle     

<br></br>
## UI



## 개발 이슈
[이슈 이름](링크 주소)

<br></br>
## 개발 회고
🧑‍💻 이영석
    
🧑‍💻 김상형
    
🧑‍💻 박지은
    
🧑‍💻 송찬혁
    
🧑‍💻 정민석
    
🧑‍💻 최보현
    
