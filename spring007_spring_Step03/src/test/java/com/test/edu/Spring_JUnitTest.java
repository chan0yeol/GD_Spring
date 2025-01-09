package com.test.edu;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.dto.BoardDto;
import com.min.edu.model.BoardDaoImpl;
import com.min.edu.model.IBoardService;

import lombok.extern.slf4j.Slf4j;

//TODO 10612 DataSource 생성 확인을 위한 JUnit 작성
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/application-context.xml",
						"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class Spring_JUnitTest {
	
	@Autowired
	private BasicDataSource dataSource;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private IBoardService service;
	
	@Test
	public void service_Test() {
		List<BoardDto> lists = service.selectBoard();
		BoardDto inDto = BoardDto.builder().id("아이디").title("test타이틀").content("test콘텐츠").build();
		assertNotEquals(0, lists.size());
		int row = service.insertBoard(inDto);
		assertEquals(1, row);
	}
	
//	@Test
	public void test() {
		System.out.println(dataSource.getDriverClassName()); 
		System.out.println(dataSource.getUrl()); 
		System.out.println(dataSource.getUsername()); 
		System.out.println(dataSource.getPassword());
		assertNotNull(dataSource);
	}
	// TODO 10613 SqlSessionTemplate Bean 생성 확인을 위한 JUnit
//	@Test
	public void myBatis_BeanTest() {
		List<BoardDto> lists = sqlSession.selectList("com.min.edu.model.BoardDaoImpl.selectBoard");
		assertNotEquals(0, lists.size());
	}
	
	

}
