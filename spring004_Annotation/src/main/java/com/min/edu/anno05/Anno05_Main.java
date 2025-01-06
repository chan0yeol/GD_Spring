package com.min.edu.anno05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Anno05_Main {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("com/min/edu/anno05/Anno05.xml");
		School obj = context.getBean("school", School.class);
		System.out.println(obj);
	}

}
