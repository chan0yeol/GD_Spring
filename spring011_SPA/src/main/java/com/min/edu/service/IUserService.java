package com.min.edu.service;

import java.util.Map;

import com.min.edu.vo.UserVo;

public interface IUserService {
	UserVo login(Map<String, Object> map);
}
