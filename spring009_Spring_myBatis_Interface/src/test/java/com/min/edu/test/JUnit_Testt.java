package com.min.edu.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.dto.JobsDto;
import com.min.edu.mapper.Mybatis_Interface_Mapper;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Slf4j
public class JUnit_Testt {

	
	@Autowired
	private Mybatis_Interface_Mapper mapper;
	
//	@Test
	public void test() {
	 	List<JobsDto> lists = mapper.selectAll("IT_PROG");
	 	log.info("lists  : {}", lists);
	 	assertNotEquals(0, lists.size());
	}
	
//	@Test
	public void selectOne_Test() {
		JobsDto dto = mapper.selectOne("IT_PROG");
		log.info("\n\n dto : {} \n\n", dto);
		assertNotNull(dto);
	}
	
	@Test
	public void selectDynamic_Test() {
		List<JobsDto> lists = mapper.selectDynamic("IT_PROG");
		log.info("\n\n {} \n\n",lists);
		assertNotEquals(0, lists.size());
	}
}
