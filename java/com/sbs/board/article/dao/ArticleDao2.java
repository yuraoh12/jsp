package com.sbs.board.article.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sbs.board.member.dao.Member;

public class ArticleDao2 implements Dao {

	public List<Article> getAllAritcles() {
		Connection conn = null;
		List<Article> articles = null;
		
		System.out.println("====== JDBC DB 접속 ======");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/t1?serverTimezone=UTC"; // 어떤 db서버
			String user = "root";
			String pass = "";
			
			conn = DriverManager.getConnection(url, user, pass);
			
			Statement stmt = conn.createStatement();
			String sql = "select * from article";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			articles = new ArrayList<>();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String body = rs.getString("body");
				
				Article article = new Article();
				article.setId(id);
				article.setTitle(title);
				article.setBody(body);
				
				articles.add(article);
			}
			
			
		} catch(ClassNotFoundException e1) {
			System.out.println("클래스를 찾지 못했습니다");
		} catch(SQLException e2) {
			System.out.println("SQL ERROR!!");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return articles;
	}

//	public void deleteArticles(String[] ids) {
//		Connection conn = null;
//		List<Article> articles = null;
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			String url = "jdbc:mysql://localhost:3306/t1?serverTimezone=UTC"; // 어떤 db서버
//			String user = "root";
//			String pass = "";
//			
//			conn = DriverManager.getConnection(url, user, pass);
//			
//			Statement stmt = conn.createStatement();
//			
//			for(int i = 0; i < ids.length; i++) {
//				String sql = "delete from article where id = " + ids[i];
//				System.out.println(sql);
//				stmt.executeUpdate(sql);
//			}
//			
//		} catch(ClassNotFoundException e1) {
//			System.out.println("클래스를 찾지 못했습니다");
//		} catch(SQLException e2) {
//			System.out.println("SQL ERROR!!");
//		} finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	public Member loginCheck(String id, String pw) {
//		Connection conn = null;
//		Member member = null;
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			String url = "jdbc:mysql://localhost:3306/t1?serverTimezone=UTC"; // 어떤 db서버
//			String user = "root";
//			String pass = "";
//			
//			conn = DriverManager.getConnection(url, user, pass);
//			
//			Statement stmt = conn.createStatement();
//			String sql = "select * from `member` where loginId = '" + id + "' and loginPw = '" + pw + "'";
//			System.out.println(sql);
//			ResultSet rs = stmt.executeQuery(sql);
//			
//			if(rs.next()) {
//				int mid = rs.getInt("id");
//				String loginId = rs.getString("loginId");
//				String loginPw = rs.getString("loginPw");
//				String nickname = rs.getString("nickname");
//				String regDate = rs.getString("regDate");
//				
//				member = new Member();
//				member.setId(mid);
//				member.setLoginId(loginId);
//				member.setLoginPw(loginPw);
//				member.setNickname(nickname);
//				member.setRegDate(regDate);
//			}
//			
//		} catch(ClassNotFoundException e1) {
//			System.out.println("클래스를 찾지 못했습니다");
//		} catch(SQLException e2) {
//			System.out.println("SQL ERROR!!");
//		} finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return member;
//	}
}