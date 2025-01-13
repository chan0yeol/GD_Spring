package com.min.edu.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.dto.EmpDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class EmpDaoImpl implements IEmpDao{
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS = "com.min.edu.repository.EmpDaoImpl.";
	@Override
	public EmpDto login(EmpDto dto) {
		return sqlSession.selectOne(NS+"loginChk",dto);
	}
	
	
}
