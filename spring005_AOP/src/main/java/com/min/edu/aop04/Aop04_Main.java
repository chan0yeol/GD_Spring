package com.min.edu.aop04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Aop04_Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/min/edu/aop04/aop-context.xml");
		IHumanWork emp = context.getBean("employee",IHumanWork.class);
		emp.work();
		IHumanWork ceo = context.getBean("ceo",IHumanWork.class);
		ceo.work();
		
	}
}
