package com.min.edu.bean01;

public class MessageBeanImpl implements IMessageBean{

	private String coffee;
	private String price;
	
	public MessageBeanImpl() {
		this.coffee = "아라비카";
		this.price = "2000";
		
		
	}
	public MessageBeanImpl(String coffee, String price) {
		super();
		this.coffee = coffee;
		this.price = price;
	}
	
	@Override
	public void call() {
		System.out.printf("%s 커피의 가격은 %s \n", coffee, price);
	}


}
