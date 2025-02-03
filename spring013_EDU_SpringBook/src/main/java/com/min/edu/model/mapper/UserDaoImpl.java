package com.min.edu.model.mapper;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.UserVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
// TODO 018 @Repository 
@Repository
@Slf4j
@RequiredArgsConstructor
public class UserDaoImpl implements IUserDao{
	// TODO 019 SqlSessionTemplate Bean 생성자 방식 DI
	private final SqlSessionTemplate sqlSession;
	private final String NS = "com.min.edu.model.mapper.UserDaoImpl.";
	@Override
	public UserVo login(Map<String, Object> map) {
		return sqlSession.selectOne(NS+"login",map);
	}
	
	
}
