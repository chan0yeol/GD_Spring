package com.min.edu.aop05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Aop05_Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/min/edu/aop05/aop-context.xml");
		IPerson left = context.getBean("rightBrain", IPerson.class);
		IPerson right = context.getBean("leftBrain", IPerson.class);
//		left.thinking();
//		right.thinking();
		
		// Auto-Proxy 반드시 Interface를 통해서 VMI 동작시키고 Weaving이 동작되도록 만들어야 한다.
		// 따라서 클래스를 통한 Bean호출 으로는 AOP동작시키지 못하고 Auto-Proxy 오류 발생
		RightBrain rr = context.getBean("rightBrain",RightBrain.class);
		rr.thinking();
		String res = rr.use("실행");
		System.out.println("반환된 결과 : "+res);
	}

}
