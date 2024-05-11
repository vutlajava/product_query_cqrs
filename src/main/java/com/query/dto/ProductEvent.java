package com.query.dto;

import com.query.entity.Product;

public class ProductEvent {
	
	private String eventType;
	private Product product;
	
	public ProductEvent() {
		
	}
	
	

	public ProductEvent(String eventType, Product product) {
		super();
		this.eventType = eventType;
		this.product = product;
	}



	/**
	 * @return the eventType
	 */
	public String getEventType() {
		return eventType;
	}



	/**
	 * @param eventType the eventType to set
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}



	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}



	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	

}
