package com.min.edu.anno06;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// TODO 100-03-02 @Component의 사용
@Component
public class UserServiceImpl implements IUserService {
	// TODO 100-02-02 @Autowired, @Resource, @Qualifier 의 사용
	
//	@Autowired
//	@Autowired
//	@Qualifier("dto01")
	
//	@Resource(name="dto01")
	
//	@Resource
//	@Qualifier(value="dto01")
//	private UserDto dto01; // 멤버필드 주입
	
	private UserDto dto01;
	
	@Autowired
	public UserServiceImpl(UserDto dto01) { // 생성자 주입
		this.dto01 = dto01;
	}
	
	public void setDto01(UserDto dto01) {
		this.dto01 = dto01;
	}

	@Override
	public void addUser() {
		System.out.println("추가된 멤버 : " + dto01.getName());
	}
}
