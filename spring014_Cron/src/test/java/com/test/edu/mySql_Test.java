package com.test.edu;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class mySql_Test {

	@Autowired
	private SqlSessionTemplate sqlTemplate;
	
	
	@Test
	public void test() {
		assertNotNull(sqlTemplate);
		String str = sqlTemplate.selectOne("com.min.edu.cron.CronDaoImpl.autoDatePrint");
		System.out.println(str);
	}

}
