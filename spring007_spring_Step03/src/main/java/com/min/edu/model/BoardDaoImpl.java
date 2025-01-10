package com.min.edu.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.dto.BoardDto;

import lombok.extern.slf4j.Slf4j;

// TODO 10604 Dao, Service class 생성
// TODO 10615 Dao 작성
@Repository
@Slf4j
public class BoardDaoImpl implements IBoardDao {
	private final String NS="com.min.edu.model.BoardDaoImpl."; 
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<BoardDto> selectBoard() {
		log.info("사용자 로거 BoardDaoImpl selectBoard");
		return sqlSession.selectList(NS+"selectBoard");
	}

	@Override
	public int insertBoard(Object dto) {
		log.info("사용자 로거 BoardDaoImpl insertBoard");
		return sqlSession.insert(NS+"insertBoard",dto);
	}

	@Override
	public int updateBoard() {
		log.info("사용자 로거 BoardDaoImpl updateBoard");
		return sqlSession.update(NS+"updateBoard");
	}

}
