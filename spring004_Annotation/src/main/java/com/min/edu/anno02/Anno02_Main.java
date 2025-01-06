package com.min.edu.anno02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Anno02_Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/min/edu/anno02/Anno02.xml");
		context.getBean("nickName");
		NickNameProp prop = context.getBean("nickNameProp", NickNameProp.class);
		System.out.println(prop);
	}
}
