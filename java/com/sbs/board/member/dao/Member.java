package com.sbs.board.member.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	private int id;
	private String loginId;
	private String loginPw;
	private String nickname;
	private String regDate;
}