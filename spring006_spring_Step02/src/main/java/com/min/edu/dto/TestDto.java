package com.min.edu.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TestDto {
	private String job_id, job_title;
	private int min_salary, max_salary;
}
