package com.min.edu.aop04;

public class CEO implements IHumanWork {

	@Override
	public void work() {
		System.out.println("O 회사의 경영에 관련된 업무를 합니다.");
	}

}
