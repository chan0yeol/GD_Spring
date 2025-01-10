package com.min.edu.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.edu.dto.BoardDto;

import lombok.extern.slf4j.Slf4j;

// TODO 10616 Service 작성
@Service
@Slf4j
public class BoardServiceImpl implements IBoardService{
	
	@Autowired
	private IBoardDao boardDao;
	
	@Override
	public List<BoardDto> selectBoard() {
		log.info("BoardServiceImpl selectBoard()");
		return boardDao.selectBoard();
	}

	@Override
	public int insertBoard(Object dto) {
		log.info("BoardServiceImpl insertBoard()");
		return boardDao.insertBoard(dto);
	}

	// TODO 10702 트랜잭션 처리를 위한 service 작성
	/*
	 * TODO 10702- @Transactional 설명
	 * @Transactional(readOnly=[true/false])
	 * true 읽기전용, false 수정/입력/삭제가 가능
	 * readOnly를 true로 설정하여 transaction이 동작하도록 만든다.
	 * 	insert혹은 update의 dao가 실행되어 예외가 발생한다면 rollback
	 * Spring은 Auto-Proxy를 통해서 service를 제어하게 된다.
	 */
	@Override
	@Transactional(readOnly = true)
	public int transaction(BoardDto dto) {
		log.info("BoardServiceImpl @Transaction을 통해서 두개의 Dao를 실행시킨다.");
		int n = boardDao.insertBoard(dto);
		int m = boardDao.updateBoard();
		return (m>0 || n>0)?1:0;
	}

}
