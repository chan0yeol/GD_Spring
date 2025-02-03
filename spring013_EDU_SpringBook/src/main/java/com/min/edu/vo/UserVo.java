package com.min.edu.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserVo {

	private String id, name, password, email, auth, enable, joindate;
}
