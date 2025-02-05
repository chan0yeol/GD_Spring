package com.min.edu.cron;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CronServiceImpl implements ICronService {
	private final ICronDao cronDao;
	
	
	@Override
	public void new_item() {
		System.out.println("------ Cron Service 실행 ------");
		cronDao.new_item();
	}

}
