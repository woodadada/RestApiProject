# RestApiProjct

Access Token을 사용한 RestApiProject 입니다.
현재 개발 중 입니다.

Access Token에 대한 이해를 목표로 잡은 프로젝트로 그 외에는 
간단한 과일, 채소 매장 검색 프로젝트입니다.

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


프로젝트 구조입니다.


## API
|Method|URL|설명|비고|
|--------------------|--------------------|-------------------|-------------------|
|Get|/fruits/product|과일 목록 조회|완료|
|Get|/fruits/product?name=딸기|과일 가격 조회|완료|
|Get|/vegetable/product|채소 목록 조회|완료|
|Get|/vegetable/product?name=호박|채소 가격 조회|완료|

## TEST

테스트는 Postman을 사용하였습니다.
front 페이지도 개발 중이라서 확인이 가능합니다.
테스트 데이터는 서버 실행 시 
WebController에서 ApplicationRunner를 구현해 run method로 insert 되고 있습니다. 

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


