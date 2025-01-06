package com.min.edu.anno04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Anno04_Main {

	public static void main(String[] args) {
		ApplicationContext con = new ClassPathXmlApplicationContext("com/min/edu/anno04/componentScan.xml");
		Radio rdo = con.getBean("radio",Radio.class);
		Television tv = con.getBean("samsung",Television.class);
		rdo.powerOn();
		tv.powerOn();
		
		// component value가 지정이 되면 가지고 있었던 Class명의 호출은 사용하지 못한다.
		IFunction tvBean = con.getBean("television", IFunction.class);
		tvBean.powerOn();
	}

}
