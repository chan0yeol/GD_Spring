package com.min.edu.cron;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CronDaoImpl implements ICronDao{
	
	private final SqlSessionTemplate sqlSession;
	private final String NS ="com.min.edu.cron.CronDaoImpl."; 
	
	@Override
	public void test() {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date times = new Date();
		String timeStr = date.format(times);
		System.out.println("스케쥴러 동작 ======> " + timeStr);
	}

	@Override
	public void new_item() {
		String str = sqlSession.selectOne(NS+"autoDatePrint");
		System.out.println("데이터베이스 호출 =====> " + str);
	}

}
