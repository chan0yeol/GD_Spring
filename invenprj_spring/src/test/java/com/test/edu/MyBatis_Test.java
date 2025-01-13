package com.test.edu;

import static org.junit.Assert.*;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.dto.StockDto;
import com.min.edu.repository.IStockInDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/application-context.xml"})
public class MyBatis_Test {
	
	@Autowired
	private DataSource dataSource;
//	@Autowired
//	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private IStockInDao dao;
	
	@Test
	public void test() {
		assertNotNull(dataSource);
	}
	
	@Test
	public void tt() {
		
//		List<StockDto> lists = sessionTemplate.selectList("com.min.edu.repository.StockInDaoImpl.selectStockInAll");
		List<StockDto> lists = dao.selectAll();
		
		assertNotEquals(0, lists.size());
	}

}
