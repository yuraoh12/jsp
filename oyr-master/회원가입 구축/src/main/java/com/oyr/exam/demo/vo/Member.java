package com.oyr.exam.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private int id;
	private String regDate;
	private String updateDate;
	private String loginId;
	private String loginPw;
	private int authLevel;
	private String name;
	private String nickname;
	private String cellphoneNum;
	private String email;
	private boolean delStatus;
	private String delDate;
	
	public String delStatusStr() {
		if(delStatus == false) {
			return "미삭제";
		}
		return "삭제";
	}
	
	public String delDateStr() {
		if(delDate == null) {
			return "없음";
		}
		return delDate.substring(2, 16);
	}
}