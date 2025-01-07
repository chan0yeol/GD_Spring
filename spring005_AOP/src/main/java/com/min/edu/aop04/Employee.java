package com.min.edu.aop04;

public class Employee implements IHumanWork{

	@Override
	public void work() {
		System.out.println("O 회사 사원이 주 기능인 일을 합니다.");
	}
	
}
