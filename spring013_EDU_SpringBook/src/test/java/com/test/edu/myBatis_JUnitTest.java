package com.test.edu;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.model.service.IUserService;
import com.min.edu.vo.UserVo;
// TODO 015 014 까지 작업 TEST
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class myBatis_JUnitTest {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private IUserService userService;
	
	@Test
	public void sqlSession_test() {
//		fail("Not yet");
		assertNotNull(sqlSession);
	}
	
//	@Test
	public void login_test() {
		assertNotNull(sqlSession);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "A001");
		map.put("password", "A001");
		UserVo loginVo = sqlSession.selectOne("com.min.edu.model.mapper.UserDaoImpl.login", map);
		System.out.println("\n\n[TEST]  "+loginVo.getJoindate()+"\n\n");
		assertNotNull(loginVo);
	}
	
	@Test
	public void service_OCP_Test() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "A001");
		map.put("password", "A001");
		UserVo userVo = userService.login(map);
		assertNotNull(userVo);
	}

}
