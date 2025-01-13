package com.min.edu.service;

import org.springframework.stereotype.Service;

import com.min.edu.dto.EmpDto;
import com.min.edu.repository.IEmpDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmpServiceImpl implements IEmpService {
	private final IEmpDao dao;

	@Override
	public EmpDto login(EmpDto dto) {
		return dao.login(dto);
	}

}
