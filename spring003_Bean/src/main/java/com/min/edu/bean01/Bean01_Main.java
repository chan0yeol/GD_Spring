package com.min.edu.bean01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bean01_Main {

	public static void main(String[] args) {
		// Spring Container의 Spring Bean Configuration 파일을 등록하여 읽어서 사용한다.
		ApplicationContext bean = new ClassPathXmlApplicationContext("com/min/edu/bean01/bean01.xml");
		IMessageBean coffee =  bean.getBean("kenya",IMessageBean.class);
		IMessageBean coffee2 =  bean.getBean("amaricano",IMessageBean.class);
		coffee.call();
		coffee2.call();
	}

}
