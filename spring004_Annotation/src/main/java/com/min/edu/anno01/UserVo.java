package com.min.edu.anno01;

import org.springframework.stereotype.Component;

/*
 * 이전에 bean 생성 방법은 Spring Bean Configuration을 통해서 <bean>으로 선언하여 사용했지만
 * @Component의 Annotation을 사용하여 작성된 클래스가 자동으로 Spring Container가 시작될 때 Bean이 자동으로 만들어 진다.
 * Spring <context:component-scan base-package> 에 의해 자동으로 Bean으로 등록 된다.
 */

@Component
public class UserVo {
	private String weather;

	public UserVo() {
		this.weather = "눈";
	}

	@Override
	public String toString() {
		return "UserVo [weather=" + weather + "]";
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

}
