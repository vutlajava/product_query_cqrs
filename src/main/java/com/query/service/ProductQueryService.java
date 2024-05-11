package com.query.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.query.dto.ProductEvent;
import com.query.entity.Product;
import com.query.repository.ProductQueryRepository;

@Service
public class ProductQueryService {
	
	
	@Autowired
	private ProductQueryRepository productQueryRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public List<Product> getProduct() {
		
		
		return productQueryRepository.findAll();
		
		
	}
	
	@KafkaListener(topics="product-event-topic",groupId="product-event-group")
	public void processProductEvents(String productEvent) {
		
		
		System.out.println(" Process" + productEvent);
		
		ObjectMapper objectMapper = new ObjectMapper();
		ProductEvent productEvent1 =null;
		try {
			productEvent1 = objectMapper.readValue(productEvent, ProductEvent.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ProductEvent productEvent1 = modelMapper.map(productEvent, ProductEvent.class);
		
		
		Product product = productEvent1.getProduct();
		
		
		  if ( productEvent1.getEventType().equals("CreateProduct")){
		  
		  productQueryRepository.save(productEvent1.getProduct());
		  
		  }else if(productEvent1.getEventType().equals("UpdateProduct")) {
		  
		  Product existingProduct =
		  productQueryRepository.findById(product.getId()).get();
		  
		  existingProduct.setName(product.getName());
		  existingProduct.setDescription(product.getDescription());
		  existingProduct.setPrice(product.getPrice());
		  productQueryRepository.save(existingProduct);
		  
		  
		  }
		 
	}
	

}
