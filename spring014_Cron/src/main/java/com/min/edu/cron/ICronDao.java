package com.min.edu.cron;

public interface ICronDao {
	/**
	 * Cron 을 통해서 6초에 한번씩 자동으로 실행되는 Dao
	 */
	void test();
	
	/**
	 * service -> dao -> mybatis를 호출하여 결과를 출력하는 Cron
	 */
	void new_item();
}
