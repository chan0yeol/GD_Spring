package com.test.edu;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;import org.apache.catalina.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.model.mapper.IUserDao;
import com.min.edu.vo.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class User_JUnitTest {

	@Autowired
	private IUserDao dao;

	@Test
	public void test() {
		UserVo loginVo = dao.getLogin(new HashMap<String,Object>() {{
			put("id","A001");
			put("password","A001");
		}});
		assertNotNull(loginVo);
		
		int chk = dao.isDuplicateCheck("A001");
		assertEquals(1, chk);
		
		UserVo inVo = UserVo.builder().name("tt").password("pass").email("test@test.net").build();
		int signupRow = dao.signupMember(inVo);
		assertEquals(1, signupRow);
		
		List<UserVo> userList = dao.userSelectAll();
		assertNotEquals(0, userList.size());
		
		List<UserVo> searchList01 =  dao.getSearcherUser(new HashMap<String, Object>(){{
			put("opt","id");
			put("keyword","A0");
		}});
		assertNotEquals(0, searchList01.size());
		List<UserVo> searchList02 =  dao.getSearcherUser(new HashMap<String, Object>(){{
			put("opt","name");
			put("keyword","햇빛");
		}});
		assertNotEquals(0, searchList01.size());
		
		String findId = dao.findId(new HashMap() {{
			put("name","햇빛");
			put("email","A001@naver.com");
		}});
		assertNotNull(findId);
	}

}
