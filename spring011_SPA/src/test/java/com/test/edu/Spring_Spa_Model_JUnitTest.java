package com.test.edu;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.service.IBoardService;
import com.min.edu.vo.BoardVo;
import com.min.edu.vo.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class Spring_Spa_Model_JUnitTest {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private IBoardService boardService;
	
	@Before
	public void test() {
		assertNotNull(sqlSession);
	}
	
	@Test
	public void boardPageTest() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("first", 1);
		map.put("last", 5);
		map.put("auth", "U");
		List<BoardVo> boardList = boardService.getAllBoardPage(map);
		assertEquals(5, boardList.size());
		
		int allCnt = boardService.getAllBoardCount(map);
		assertNotEquals(0, allCnt);
	}
	
	@Test
	public void login_Test() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "A001");
		map.put("password", "A001");
		UserVo loginVo = sqlSession.selectOne("com.min.edu.mapper.UserDaoImpl.login",map);
		assertNotNull(loginVo);
	}

}
