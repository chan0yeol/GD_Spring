package com.edu.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.dto.TestDto;

// TODO JUnit 설정
// Spring + JUnit
// SpringBoot에서는 @SpringBootTest를 작성해 주면 된다.
// Spring 에서는 각 spring bean configuration의 파일은 Context를 통해 읽을 수 있도록 해줘야 함.

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/application-context.xml"} )
public class Spring_Model_JUnitTest {

	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Before
	public void before() {
		System.out.println("Spring JUnit Test 시작");
	}
	@After
	public void after() {
		System.out.println("Spring JUnit Test 종료");
	}
	
	@Test
	public void test() {
		SqlSessionTemplate session = (SqlSessionTemplate)context.getBean("sqlSessionTemplate");
		System.err.println(session);
		BasicDataSource dbcp = (BasicDataSource) context.getBean("dataSource");
		System.err.println(dbcp.getDriverClassName());
		System.err.println(dbcp.getUrl());
		System.err.println(dbcp.getUsername());
		System.err.println(dbcp.getPassword());
		assertNotNull(session);
	}
	
	@Test
	public void myBatis_test() {
		List<TestDto> dtos = sqlSession.selectList("spring_mybatis.testSelectAll");
		for(TestDto t : dtos) {
			System.out.println(t);	
		}
		assertNotEquals(0, dtos.size());
 	}

}
