package com.min.edu.aop02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Aop02_Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/min/edu/aop02/aop-context.xml");
		IHumanWork emp = context.getBean("employee", IHumanWork.class);
		emp.work();
		
	}
}
