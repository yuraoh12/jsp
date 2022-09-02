package home.db.Article;


public class Article {
	
	private int id;
	private String title;
	private String body;
	private String memberId;
	private String regDate;
	private int hit;
	
	public Article() {
		super();
	}

	public Article(int id, String title, String body, String memberId, String regDate, int hit) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.memberId = memberId;
		this.regDate = regDate;
		this.hit = hit;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
}
