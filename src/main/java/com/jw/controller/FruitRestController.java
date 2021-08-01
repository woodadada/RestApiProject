package com.jw.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jw.constants.CodeConst;
import com.jw.model.Product;
import com.jw.service.ProductService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author wjddn
 * @RequiredArgsConstructor 어노테이션은 final 키워드를 갖는 클래스변수들을 초기화해주는 생성자를 만들어냅니다.
 * 즉, Bean을 주입받을 때 @Autowired 타입 주입방법을 선택하는 것이 아닌 생성자 주입을 받도록 유도합니다.
 */
@RequestMapping("/fruits")
@RequiredArgsConstructor
@RestController
public class FruitRestController {
	
	private final ProductService productService;
	/**
	 * 과일 목록 조회
	 * 과일 가격 조회
	 */
	
	@GetMapping(value = "/product")
    public ResponseEntity<List<Product>> getFruitList(@RequestParam(value = "name", required = false) String name) throws Exception {
		
		List<Product> list = productService.findAll(Product.builder().productNm(name).productTp(CodeConst.PRODUCT_TYPE_FRUIT.getValue()).build());
		
		if(list.isEmpty() || list.size() < 1) {
			return ResponseEntity.badRequest().build();
		}else {
			return ResponseEntity.ok(list);
		}
    }
}
