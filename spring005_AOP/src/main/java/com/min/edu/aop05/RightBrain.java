package com.min.edu.aop05;

import org.springframework.stereotype.Component;

@Component
public class RightBrain implements IPerson {

	@Override
	public void thinking() {
		System.out.println("오른쪽 뇌가 생각한다 SQLD");
	}
	
	// Auto-Proxy의 대상이 되지 않는다.
	public String use(String action) {
		System.out.println("반환과 Argument가 있는 메소드");
		return action+"한다";
	}
}
