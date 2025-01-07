package com.min.edu.aop03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Aop03_Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/min/edu/aop03/aop-context.xml");
		
		IHumanWork emp = context.getBean("employee",IHumanWork.class);
		System.out.println("emp.work()");
		emp.work();
		System.out.println("==============================");
		IHumanWork ceo = context.getBean("ceo", IHumanWork.class);
		System.out.println("ceo.work()");
		ceo.work();
	}
}
