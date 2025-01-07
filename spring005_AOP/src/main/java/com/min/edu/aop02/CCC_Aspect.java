package com.min.edu.aop02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CCC_Aspect implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object resObj = null;
		System.out.println("메소드를 실행한다."); // Before
		try {
			resObj = invocation.proceed(); // CC를 끌고 오게 함. Proxy
		} catch (Throwable e) {
			System.out.println("오류 발생 했다."); // afterThrowing
		} finally {
			System.out.println("메소드 종료 되었다."); // after 
		}
		
		return resObj;
	}

}
