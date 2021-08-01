package com.jw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.jw.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
	/**
	 * 추후 JpaSpecificationExecutor 사용하기 
	 */
	
	// 제품 코드로 제품 조회
	List<Product> findAllByProductTp(String productTp);
	
	// 제품 코드와 상품 명으로 제품 조회
	List<Product> findAllByProductNmAndProductTp(String productNm, String productTp);
}
