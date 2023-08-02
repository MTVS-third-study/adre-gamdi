
# 🏝️ : Adregamdi

  <img src="https://github.com/MTVS-third-study/adregamdi/assets/134986842/bb17367c-9dbc-4729-a5fd-d43c9a17b464" width="200" height="200">

<br>

> **메타버스 아카데미 감귤포장학과** <br/> **개발기간: 2023.07.03 ~ 2022.07.30**

<br>

## 🧑🏻‍💻팀원 목록👩🏻‍💻
| 김종완 | 안희찬 | 조만제 | 이정민 | 이효진 |
| --- | --- | --- | --- | --- |
|<img width="160px" src="https://avatars.githubusercontent.com/u/115992753?v=4" />| <img width="160px" src="https://avatars.githubusercontent.com/u/134986842?v=4"/> | <img width="160px" src="https://avatars.githubusercontent.com/u/98208452?v=4" /> | <img width="160px" src="https://avatars.githubusercontent.com/u/96166174?v=4" /> | <img width="160px" src="https://avatars.githubusercontent.com/u/134986912?v=4" /> |
|<center>[@Subak-Uncle](https://github.com/Subak-Uncle)| <center>[@ahnichan](https://github.com/ahnichan)| <center>[@fakerdeft](https://github.com/fakerdeft)| <center>[@max0901](https://github.com/max0901)| <center>[@hodin030](https://github.com/hodin030)|

<br>

## ⛱️ : 프로젝트 소개 
이번 제주도 여행은 _**어드레감디~~?**_

저희 _**어드레감디**_ 는 오직 제주도만을 위한 여행 계획에 도움을 주는 플랫폼입니다. 
지도에서 제주도 지역 한정 여행 정보들을 제공해주어 사용자들이 손쉽게 여행 계획을 세울 수 있도록 서비스를 제공합니다.

제주도 여행을 계획하고 있다면 어드레감디와 함께 특별한 여행을 시작해보세요! 
제주도로 떠나는 모든 회원분들의 일행이 완벽한 제주도 여행을 위해 함께 계획하고 실현해드립니다!

<h6>* 어드레감디 - 어디로 가느냐 제주 방언</h6>

<br>

## 🖼️ : 프로젝트 목표
### 개발

- 스프링 부트를 사용한 웹 어플리케이션 개발
- 효율적인 개발을 위한 TDD 방식 적용
- 유지/보수를 위한 Layered Architecture 적용
- JPA & Mybatis를 사용해 DB 연동
- 서비스 제공을 로컬이 아닌 실제 사용자에게 하는 배포

### 기술 스택
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"> <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> 

### 제작 의도
제주도 여행 시 지역 카테고리별 정보 불균형과 일정 관리에 대한 불편함을 해소하고자<br>
특정 지역 카테고리별 정보 제공 및 나만의 제주도 일정 플래너 지원

<img width="493" alt="image" src="https://github.com/MTVS-third-study/adregamdi/assets/134986842/6236b01b-2dfe-4237-9a50-665d754e2c92">
<img width="587" alt="image" src="https://github.com/MTVS-third-study/adregamdi/assets/115992753/bee5131c-d371-4af9-927e-52756de4b78b">



<br>
<br>

## 📗 : 프로젝트 세부 사항

[WiKi](https://github.com/MTVS-third-study/adregamdi/wiki)


### 장점

- 제주도 한정 웹 어플리케이션이기 때문에 사용자 확보 유리


### 사용자 워크 플로우

- 사이트 접속
- 회원가입 및 로그인 모달
- 작성 중인 일정 있으면 불러오기/취소 선택 or 없으면 곧바로 메인 페이지에서 지역 포인트 클릭
- 포인트 클릭 시 카테고리 선택창(원형으로) 나오고 카테고리 선택 시 해당 포인트 근처에 카테고리와 부합하는 정보를 지도와 좌측 사이드바에 제공
- 원하는 정보를 담고 시간대 설정을 하면 우측 하단에 있는 일정 플로우에 자동으로 담기고 임시 저장 버튼을 통해 임시 저장 가능
- 좌측 햄버거 버튼을 누르면 사이드바가 열리고 검색 가능
- 마이페이지에서 내 정보 및 일정 확인 가능

### 기능 목록

- 회원가입/로그인/로그아웃
-  마이 페이지(내 정보 관리/내 일정 조회)
- 관리자 페이지(회원 정보 관리/블랙리스트 관리)
- 우수 리뷰어 등급 변경
- 검색 기능
- 검색 키워드 DB에 등록/삭제
- 일정 임시 저장/수정/삭제
- 일정 최종 저장/수정/삭제
- 카테고리 등록/수정/삭제
- 장소 정보 등록/수정/삭제
- 장소 사진 등록/수정/삭제
- 리뷰 등록/수정/삭제
- 리뷰 별점/좋아요/싫어요/신고
- 리뷰 작성자 아이디 누르면 해당 유저의 일정 조회

### 기능 건의

- 다양한 일정 리스트로 저장 기능
- 마이 페이지에서 내 일정 리스트로 보여주고 누르면 수정하는 기능
- 장소와 장소 사이 이동수단별 예상 시간 제공
- 리뷰 댓글 기능
