package com.query.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.query.entity.Product;
import com.query.repository.ProductQueryRepository;
import com.query.service.ProductQueryService;

@RequestMapping("/products")
@RestController
public class ProductQueryController {
	
	
	@Autowired
	private ProductQueryService productQueryService;
	
	public List<Product> fetachAllProducts(){
		
		return productQueryService.getProduct();
	}

}
