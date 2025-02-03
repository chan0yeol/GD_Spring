package com.min.edu.model.mapper;

import java.util.Map;

import com.min.edu.vo.UserVo;
// TODO 018 Dao 메소드 정의
public interface IUserDao {
	UserVo login(Map<String, Object> map);
}
