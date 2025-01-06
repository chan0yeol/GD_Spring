package com.min.edu.bean02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bean02_Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/min/edu/bean02/bean02.xml");
		Employee emp01 = (Employee) context.getBean("myAddr01");
		System.out.println(emp01);
		Employee emp02 = context.getBean("myAddr02", Employee.class);
		System.out.println(emp02);
		JobAddress dev = context.getBean("dev", JobAddress.class);
		System.out.println(dev);
		JobAddress sing = (JobAddress) context.getBean("sing");
		System.out.println(sing);
	}

}
