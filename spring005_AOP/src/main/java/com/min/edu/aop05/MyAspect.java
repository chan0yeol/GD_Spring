package com.min.edu.aop05;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

	@Pointcut("execution(public void com.min.edu.aop05.LeftBrain.*(..))")
	public void usePointCutLeftBrain() {

	}

	@Pointcut("execution(public void com.min.edu.aop05.RightBrain.*(..))")
	public void usePointCutRightBrain() {

	}

	@Pointcut("execution(public void com.min.edu.aop05.*.*(..))")
	public void usePointCutBrain() {

	}

	@Before("usePointCutBrain()")
	public void before() {
		System.out.println("메소드가 실행 될 때 공통으로 시작됨 ");
	}

	@After("usePointCutLeftBrain()")
	public void afterLeft() {
		System.out.println("난 왼쪽 뇌가 생각하는 오른쪽");
	}

	@After("usePointCutRightBrain()")
	public void afterRight() {
		System.out.println("난 오른쪽 뇌가 생각하는 왼쪽");
	}
	
	
	// Argument가 있고 반환이 있는 메소드 실행시킬 때의 결과
	@AfterReturning(pointcut =  "execution(public * *(..)))" , returning = "result")
	public void afterReturnning(JoinPoint joinPoint, Object result) {
		System.out.println("!@#$%" + joinPoint.getSignature().getName() + "!@$@!%");
		Object[] obj = joinPoint.getArgs();
		for (Object object : obj) {
			System.out.println("메소드를 실행하기 위한 Arguments : " + object.toString());
		}

		System.out.println("반환된 결과의 값 : " + result);
	}
}
