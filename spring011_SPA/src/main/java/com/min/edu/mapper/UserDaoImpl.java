package com.min.edu.mapper;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.UserVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
@RequiredArgsConstructor
public class UserDaoImpl implements IUserDao {
	private final SqlSessionTemplate sqlSession;
	private final String NS = "com.min.edu.mapper.UserDaoImpl.";
	@Override
	public UserVo login(Map<String, Object> map) {
		return sqlSession.selectOne(NS+"login",map);
	}

}
