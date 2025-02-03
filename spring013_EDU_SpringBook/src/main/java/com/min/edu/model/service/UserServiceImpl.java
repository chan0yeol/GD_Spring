package com.min.edu.model.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.min.edu.model.mapper.IUserDao;
import com.min.edu.vo.UserVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// TODO 017 Service 작성
@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
	
	private final IUserDao userDao;

	@Override
	public UserVo login(Map<String, Object> map) {
		return userDao.login(map);
	}

}
