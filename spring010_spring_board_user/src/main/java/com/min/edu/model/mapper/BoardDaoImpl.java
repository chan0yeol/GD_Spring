package com.min.edu.model.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.BoardVo;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardDaoImpl implements IBoardDao{

	private final SqlSessionTemplate session;
	private final String NS = "com.min.edu.model.mapper.BoardDaoImpl.";
	
	@Override
	public List<BoardVo> userBoardList() {
		return session.selectList(NS+"userBoardList");
	}

	@Override
	public int delflagBoard(List<String> seqs) {
		return session.delete(NS+"delflagBoard", seqs);
	}

	@Override
	public int writeBoard(BoardVo boardVo) {
		return session.insert(NS+"writeBoard",boardVo);
	}

	@Override
	public BoardVo getOneBoard(String seq) {
		return session.selectOne(NS+"getOneBoard",seq);
	}

	@Override
	public int replyUpdate(BoardVo boardVo) {
		return session.update(NS+"replyUpdate",boardVo);
	}

	@Override
	public int replyInsert(BoardVo boardVo) {
		return session.insert(NS+"replyInsert",boardVo);
	}

	@Override
	public List<BoardVo> restoreBoard() {
		return session.selectList(NS+"restoreBoard");
	}

	@Override
	public int restoreDelflag(List<String> seqs) {
		return session.update(NS+"restoreDelflag",seqs);
	}

}
