package com.min.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;

import com.min.edu.dto.JobsDto;

public interface Mybatis_Interface_Mapper {

	@Select("SELECT JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY FROM JOBS")
	public List<JobsDto> selectAll(String seq);

	@Select("SELECT JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY FROM JOBS WHERE JOB_ID = #{seq}")
	JobsDto selectOne(String seq);

	@SelectProvider(type = JobsProvider.class, method = "getSelect")
	List<JobsDto> selectDynamic(String seq);

	@SelectKey(statement = "SELECT JOB_SEQ.NEXTVAL FROM DUAL", keyProperty = "job_id", before = true, resultType = String.class)
	@Insert("INSERT INTO JOBS VALUES(#{job_id},#{job_title},#{min_salary},#{max_salary}")
	public void insertJob(JobsDto dto);
}
