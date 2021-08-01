package com.jw.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author wjddn
 * "@NoArgsConstructor" 더미 데이터 생성 시 오류 발생하여 사용한 어노테이션
 * Hibernate 에서는 Reflection 으로 Entity Object 를 생성하기 때문에 모든 Entity 는 default constructor 를 갖고 있어야 한다
 * 
 *
 */
@NoArgsConstructor
@Data
@Entity
@Table(name = "product")
public class Product {
	
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
	
	@Builder
	public Product(String productTp, String productNm, BigDecimal productPr) {
		this.productTp = productTp;
		this.productNm = productNm;
		this.productPr =productPr;
		this.regDt = new Date();
	}
	
}
