package com.min.edu.aop01;

/*
 *  ★ : CC 
 *  ○ : CCC 
 */
public class HomeWork {

	public void workProcess() {
		System.out.println("○○○○○ 업무를 시작하기 전에 준비운동 ○○○○○");
		try {
			System.out.println("★★★★★ 주된 업무를 시작 ★★★★★");
		} catch (Exception e) {
			System.out.println("○○○○○ 업무 중 조퇴함 ○○○○○");
		} finally {
			System.out.println("○○○○○ 업무가 퇴근함 ○○○○○");
		}
	}
	
}
