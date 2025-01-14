package com.test.edu;

import static org.junit.Assert.*;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.aop.DaoLogAop_XML;
import com.min.edu.model.mapper.IUserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class Bean_JUnitTest {

	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	private IUserDao userDao;
	
//	@Test
	public void bean_test() {
		BasicDataSource dataSource = context.getBean("dataSource",BasicDataSource.class);
		System.out.println(dataSource.getDriverClassName());
		System.out.println(dataSource.getMaxActive());
		assertNotNull(sqlSessionTemplate);
	}
	
//	@Test
	public void dao_Test() {
		int n = userDao.isDuplicateCheck("A001");
	}
	
	@Test
	public void bean_aop_test() {
		DaoLogAop_XML aop_XML = context.getBean("daoLogAop_XML", DaoLogAop_XML.class);
		assertNotNull(aop_XML);
	}

}
