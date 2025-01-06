package com.min.edu.anno03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.min.edu.anno03.bean.NickName03;

@Component
public class NickNameProp03 {
	
	// Spring Container가 관리하고 있는 bean 중에 type이 NickName03인 bean을 주입하여 사용하겠다.
	@Autowired
	private NickName03 nickName;

	@Override
	public String toString() {
		return "NickNameProp [nickName=" + nickName + "]";
	}

	public NickName03 getNickName() {
		return nickName;
	}

	public void setNickName(NickName03 nickName) {
		this.nickName = nickName;
	}
	
}
