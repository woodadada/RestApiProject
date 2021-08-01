package com.jw.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jw.model.Product;
import com.jw.repository.ProductRepository;

@Controller
public class WebController implements ApplicationRunner {
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		String type = "fruit";
		
		List<Product> list = new ArrayList<>();
		list.add(productRepository.save(Product.builder().productTp(type).productNm("딸기").productPr(new BigDecimal("1500")).build()));
		list.add(productRepository.save(Product.builder().productTp(type).productNm("수박").productPr(new BigDecimal("4500")).build()));
		list.add(productRepository.save(Product.builder().productTp(type).productNm("망고").productPr(new BigDecimal("6000")).build()));
		list.add(productRepository.save(Product.builder().productTp(type).productNm("포도").productPr(new BigDecimal("7000")).build()));
		list.add(productRepository.save(Product.builder().productTp(type).productNm("망고스틴").productPr(new BigDecimal("15000")).build()));
		list.add(productRepository.save(Product.builder().productTp(type).productNm("메론").productPr(new BigDecimal("23000")).build()));
		list.add(productRepository.save(Product.builder().productTp(type).productNm("블루베리").productPr(new BigDecimal("5000")).build()));
		
		type = "vegetable";
		list.add(productRepository.save(Product.builder().productTp(type).productNm("상추").productPr(new BigDecimal("1500")).build()));
		list.add(productRepository.save(Product.builder().productTp(type).productNm("가지").productPr(new BigDecimal("4500")).build()));
		list.add(productRepository.save(Product.builder().productTp(type).productNm("호박").productPr(new BigDecimal("6000")).build()));
		list.add(productRepository.save(Product.builder().productTp(type).productNm("고구마").productPr(new BigDecimal("7000")).build()));
		list.add(productRepository.save(Product.builder().productTp(type).productNm("꺳잎").productPr(new BigDecimal("15000")).build()));
		list.add(productRepository.save(Product.builder().productTp(type).productNm("감자").productPr(new BigDecimal("23000")).build()));
		list.add(productRepository.save(Product.builder().productTp(type).productNm("대파").productPr(new BigDecimal("5000")).build()));
		
		for(Product p : list) {
			productRepository.save(p);
		}
		
	}

	@RequestMapping("/")
	public String jspCheck(Model model) {
		
		model.addAttribute("name", "name 입니다.");
		return "index";
	}
}
