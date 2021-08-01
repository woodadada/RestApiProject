package com.jw;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jw.model.Product;
import com.jw.repository.ProductRepository;

@SpringBootTest
class FruitProjectApplicationTests {
	
	@Autowired
	ProductRepository productRepository;
	
	@After
    public void cleanup() {
		productRepository.deleteAll();
    }

	@Test
	public void productTest() {
		String type = "fruit";
		String name = "상추";
		BigDecimal price = new BigDecimal("1500");
		
		System.out.println(productRepository.save(Product.builder()
				.productTp(type)
				.productNm(name)
				.productPr(price)
				.build()));
		
//		List<Product> list = productRepository.findAll();
//		
//		Product product = list.get(0);
//		
//		assertThat(product.getProductTp()).isEqualTo(type);
//		assertThat(product.getProductNm()).isEqualTo(name);
//		assertThat(product.getProductPr()).isEqualTo(price);
	}
}
