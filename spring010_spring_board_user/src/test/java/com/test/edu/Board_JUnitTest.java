package com.test.edu;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.model.mapper.IBoardDao;
import com.min.edu.vo.BoardVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class Board_JUnitTest {
	
	@Autowired
	private IBoardDao dao;
	
//	@Test
	public void userBoardList_Test() {
		List<BoardVo> lists =  dao.userBoardList();
		assertNotEquals(0, lists.size());
		
		BoardVo inVo = BoardVo.builder().id("A001").title("Builder패턴타이틀").content("Builder Content").build();
		int writeRow = dao.writeBoard(inVo);
		assertEquals(1, writeRow);
		
		BoardVo oneVo = dao.getOneBoard("204");
		assertNotNull(oneVo);
		
		List<BoardVo> restoreList = dao.restoreBoard();
		assertNotEquals(0, restoreList.size());
		
		int resDelflagRow = dao.restoreDelflag(List.of("4","5","6"));
		assertEquals(3, resDelflagRow);
		
		int delChk = dao.delflagBoard(List.of("201","202","203"));
		assertEquals(3, delChk);
		
	}
	
	@Test
	public void reply_test() {
		BoardVo inVo = BoardVo.builder().seq(47).id("A002").title("답글답글답글").content("ㄷ답글답글답글컨텐츠").build();
		int n = dao.replyUpdate(inVo);
		assertEquals(2, n);
		int m = dao.replyInsert(inVo);
		assertEquals(1, m);
	}
	

}
