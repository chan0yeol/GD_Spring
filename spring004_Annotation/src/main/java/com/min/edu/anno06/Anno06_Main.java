package com.min.edu.anno06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Anno06_Main {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("com/min/edu/anno06/Anno06.xml");
//		IUserService service = context.getBean("userServiceImpl", IUserService.class);
//		service.addUser();
		
		// TODO 100-04-01 4.3버전 이후 권장하는 주입 방식
		IUserService service = context.getBean("userServiceImpl2", IUserService.class);
		service.addUser();
	}

}
