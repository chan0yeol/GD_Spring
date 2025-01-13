package com.min.edu.mapper;

import org.apache.ibatis.jdbc.SQL;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JobsProvider {
	
	
	public String getSelect(String seq) {
		//SELECT JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY FROM JOBS WHERE JOB_ID = #{seq}
		SQL sql = new SQL() {
			{
				SELECT("JOB_ID");
				SELECT("JOB_TITLE");
				SELECT("MIN_SALARY");
				SELECT("MAX_SALARY");
				FROM("JOBS");
				if(seq != null && !seq.isEmpty()) {
					WHERE("JOB_ID = #{seq}");
				}
						
			}
		};
		log.info("\n\n {} \n\n",sql.toString());
		return sql.toString();
	}
}
