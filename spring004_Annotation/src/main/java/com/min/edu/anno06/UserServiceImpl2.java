package com.min.edu.anno06;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

/* TODO 100-04 Spring Framework 4.3 이후의 생성자 주입 방법
 * 멤버필드를 final로 선언하고 lombok의 생성자 주입을 통해서 한번만 받는다.
 *   권장하는 이유 : 
 *   	1) 순환 참조 방지
 *   	2) 테스트 코드를 작성하기가 쉽다.
 *   	3) 이상 코드 제거
 *   	4) 객체 변이 방지 (final)
 */

@Component(value= "userServiceImpl2")
@RequiredArgsConstructor
public class UserServiceImpl2 implements IUserService{
	
	private final UserDto userDto;
	
	@Override
	public void addUser() {
		System.out.println("추가된 멤버스2 : " + userDto.getName());
	}
}
















