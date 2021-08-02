# RestApiProjct

Access Token을 사용한 RestApiProject 입니다.
현재 개발 중 입니다.

Access Token에 대한 이해를 목표로 잡은 프로젝트로 그 외에는 
간단한 과일, 채소 가게의 검색 프로젝트입니다.

## 프로젝트 개발 환경
```
IDE : STS 4
JAVA : jdk 11
DB : H2
ORM : JPA
lombok
Front : JavaScipt
HTML : bootstrap
```

## 프로젝트 구조

```
C:.
├─gradle
│  └─wrapper
└─src
    ├─main
    │  ├─java
    │  │  └─com
    │  │      └─jw
    │  │          ├─configuration
    │  │          │  ├─exception
    │  │          │  └─model
    │  │          ├─constants
    │  │          ├─controller
    │  │          ├─model
    │  │          ├─repository
    │  │          └─service
    │  ├─resources
    │  │  ├─static
    │  │  │  ├─css
    │  │  │  ├─fonts
    │  │  │  └─js
    │  │  └─templates
    │  └─webapp
    │      └─WEB-INF
    │          └─jsp
    └─test
        └─java
            └─com
                └─jw
```
프로젝트 구조입니다.


## API
|Method|URL|설명|비고|
|--------------------|--------------------|-------------------|-------------------|
|Get|/fruits/product|과일 목록 조회|완료|
|Get|/fruits/product?name=딸기|과일 가격 조회|완료|
|Get|/vegetable/product|채소 목록 조회|완료|
|Get|/vegetable/product?name=호박|채소 가격 조회|완료|

## Front 화면 설명 로그인
![image](https://user-images.githubusercontent.com/60130985/127902605-f672ed00-dff5-493f-877f-1e66b6b32fb3.png)
```
ID : user1
PW : pass
```

![image](https://user-images.githubusercontent.com/60130985/127902984-c2d04f34-20aa-4cab-89fa-5a5e81b0d4d9.png)
```
로그인 후에 노출 되는 화면 입니다.
제품 분류 별 토큰 발급은 미개발 상태이며 통합 토큰을 발급하고 있습니다.
토큰 발급이 선행되어야 정보 조회가 가능합니다.
```

## TEST

테스트는 Postman을 사용하였습니다.
front 페이지도 개발 중이라서 확인이 가능합니다.
테스트 데이터는 서버 실행 시 
WebController에서 ApplicationRunner를 구현해 run method로 insert 되고 있습니다. 

2021-08-03
oauth access token 이 추가 개발되어 token을 같이 넣어야 조회가 되고 있습니다.

```
http://localhost:8080 로컬 접속 주소 입니다.

/fruits/product - 과일의 목록 정보 노출

/fruits/product?name=딸기 - 해당 검색어의 가격 정보 노출

/fruits/product?name=없는과일 - service 단에서 구현한 BadRequest error 발생, RestExceptionHandler 를 통해 front 에러 코드, 메세지 노출

/vegetable/product - 채소의 목록 정보 노출

/vegetable/product?name=호박 - 해당 검색어의 가격 정보 노출

/vegetable/product?name=없는채소 - service 단에서 구현한 BadRequest error 발생, RestExceptionHandler 를 통해 front 에러 코드, 메세지 노출
```


## Product MODEL
```
    // 제품 식별 번호
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// 제품 타입 - 과일, 채소
	@Column(nullable = false)
	private String productTp;
	
	// 제품 명
	@Column(nullable = false)
	private String productNm;
	
	// 제품 가격
	@Column(nullable = false)
	private BigDecimal productPr;
	
	// 등록 일자
	@Column
	private Date regDt;
  
```





