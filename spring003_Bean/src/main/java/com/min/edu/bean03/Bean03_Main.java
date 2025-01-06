package com.min.edu.bean03;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bean03_Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/min/edu/bean03/bean03.xml");
		System.out.println(context.getBean("now"));
		System.out.println(context.getBean("myDate"));
		UserDto dto = context.getBean("myDto", UserDto.class);
		System.out.println(dto);
		System.out.println(dto.getName());
		System.out.println(dto.getPer());
		 
		
		UserServiceImpl userServiceImpl = context.getBean("userServiceImpl", UserServiceImpl.class);
//		userServiceImpl.addUser(dto);
		userServiceImpl.getUser();
	}

}
