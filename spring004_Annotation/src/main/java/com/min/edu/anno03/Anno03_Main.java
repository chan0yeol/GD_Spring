package com.min.edu.anno03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Anno03_Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/min/edu/anno03/anno03.xml");
		NickNameProp03 prop03 = context.getBean("nickNameProp03", NickNameProp03.class);
		System.out.println(prop03);
	}

}
