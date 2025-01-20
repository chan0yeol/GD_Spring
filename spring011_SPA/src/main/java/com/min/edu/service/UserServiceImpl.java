package com.min.edu.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.min.edu.mapper.IUserDao;
import com.min.edu.vo.UserVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
	
	private final  IUserDao userDao;
	
	@Override
	public UserVo login(Map<String, Object> map) {
		log.info("UserServiceImp login {}", map);
		return userDao.login(map);
	}

}
