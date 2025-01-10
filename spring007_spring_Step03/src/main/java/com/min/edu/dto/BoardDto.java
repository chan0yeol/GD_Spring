package com.min.edu.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class BoardDto {
	private String seq;
	private String id , title , content , regdate , delflag;
	
}
