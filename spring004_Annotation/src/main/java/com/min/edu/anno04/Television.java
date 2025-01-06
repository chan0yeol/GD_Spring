package com.min.edu.anno04;

import org.springframework.stereotype.Component;

@Component(value = "samsung")
public class Television implements IFunction {

	@Override
	public void powerOn() {
		System.out.println("티비 켜다");
	}

	@Override
	public void powerOff() {
		System.out.println("티비 끄다");
		
	}

}
