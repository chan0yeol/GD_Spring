package com.min.edu.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeptDto {
	private int deptno;
	private String dname,
	loc;
}
