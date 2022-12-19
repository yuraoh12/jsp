package home.db.member;


public class Member {
	int memberId;
	String loginId;
	String loginPw;
	String realName;
	String nickName;
	
	public Member() {}
	
	public Member(int memberId, String loginId, String loginPw, String realName, String nickName) {
		super();
		this.memberId = memberId;
		this.loginId = loginId;
		this.loginPw = loginPw;
		this.realName = realName;
		this.nickName = nickName;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPw() {
		return loginPw;
	}

	public void setLoginPw(String loginPw) {
		this.loginPw = loginPw;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
}