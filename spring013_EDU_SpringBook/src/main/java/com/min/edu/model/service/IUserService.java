package com.min.edu.model.service;

import java.util.Map;

import com.min.edu.vo.UserVo;
// TODO 017 Service 메소드 정의
public interface IUserService {
	UserVo login(Map<String, Object> map);
	
}
