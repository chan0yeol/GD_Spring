package com.min.edu.mapper;

import java.util.List;
import java.util.Map;

import org.checkerframework.checker.units.qual.m;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.BoardVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
@RequiredArgsConstructor
public class BoardDaoImpl implements IBoardDao {
	
	private final SqlSessionTemplate sqlSession;
	private final String NS = "com.min.edu.mapper.BoardDaoImpl.";
	@Override
	public List<BoardVo> getAllBoardPage(Map<String, Object> map) {
		return sqlSession.selectList(NS+"getAllBoardPage",map);
	}

	@Override
	public int getAllBoardCount(Map<String, Object> map) {
		return sqlSession.selectOne(NS+"getAllBoardCount", map);
	}

	@Override
	public int setBoardDelflag(String seq) {
		return sqlSession.delete(NS+"setBoardDelflag",seq);
	}

	@Override
	public BoardVo getOneBoard(String seq) {
		return sqlSession.selectOne(NS+"getOneBoard",seq);
	}

	@Override
	public int setBoardUpdate(Map<String, Object> map) {
		return sqlSession.update(NS+"setBoardUpdate",map);
	}

	@Override
	public int setReplyUpdate(BoardVo boardVo) {
		return sqlSession.update(NS+"replyUpdate", boardVo);
	}

	@Override
	public int setReplyInsert(BoardVo boardVo) {
		return sqlSession.update(NS+"replyInsert", boardVo);
	}

}
