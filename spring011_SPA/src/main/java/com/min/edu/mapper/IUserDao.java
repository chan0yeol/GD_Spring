package com.min.edu.mapper;

import java.util.Map;

import com.min.edu.vo.UserVo;

public interface IUserDao {
	UserVo login(Map<String, Object> map);
}
