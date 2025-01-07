package com.min.edu.aop05;

import org.springframework.stereotype.Component;

@Component
public class LeftBrain implements IPerson{

	@Override
	public void thinking() {
		System.out.println("왼쪽 뇌가 저녁음식을 생각 하고 있다.");
	}

}
