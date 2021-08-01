package com.jw.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.jw.configuration.exception.BadRequestException;
import com.jw.model.Product;
import com.jw.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author wjddn
 * @RequiredArgsConstructor 어노테이션은 final 키워드를 갖는 클래스변수들을 초기화해주는 생성자를 만들어냅니다.
 * 즉, Bean을 주입받을 때 @Autowired 타입 주입방법을 선택하는 것이 아닌 생성자 주입을 받도록 유도합니다.
 */
@RequiredArgsConstructor
@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	
	public List<Product> findAll(Product product) throws Exception {
		
		List<Product> list = new ArrayList<>();
		
		// 사용자가 품명으로 가격을 검색할 때 
		if(null != product.getProductNm()) {
			
			list = productRepository.findAllByProductNmAndProductTp(product.getProductNm(), product.getProductTp());
			
			return checkList(list);
			// 빈 list [] 이 return 되어 error 발생안되므로 위의 코드로 변환
//			return Optional.ofNullable(
//					productRepository.findAllByProductNmAndProductTp(
//							product.getProductNm()
//							, product.getProductTp()))
//							.orElseThrow(
//							() -> new EntityNotFoundException("해당 검색어의 제품이 없습니다."));
			
		}else {// 사용자가 제품 타입으로 검색할 때 ex) fruit
			list = productRepository.findAllByProductTp(product.getProductTp());
			
			return checkList(list);
			// 빈 list [] 이 return 되어 error 발생안되므로 위의 코드로 변환
			//return Optional.ofNullable(productRepository.findAllByProductTp(product.getProductTp())).orElseThrow(() -> new EntityNotFoundException("해당 타입의 제품이 없습니다."));		
		}
	}
	
	/**
	 * Product list null 체크 공통 메소드
	 * @param list
	 * @return
	 */
	public List<Product> checkList(List<Product> list){
		if(null != list && list.size() > 0) {
			return list;
		}else {
			throw new BadRequestException("해당 제품이 없습니다.");
		}
	}
}
