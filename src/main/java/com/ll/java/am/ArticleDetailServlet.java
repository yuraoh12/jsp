package com.KoreaIT.java.am;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import com.KoreaIT.java.am.config.Config;
import com.KoreaIT.java.am.exception.SQLErrorException;
import com.KoreaIT.java.am.util.DBUtil;
import com.KoreaIT.java.am.util.SecSql;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/article/detail")
public class ArticleDetailServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");

		Connection conn = null;

		try {
			Class.forName(Config.getDBDriverClassName());
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		try {
			conn = DriverManager.getConnection(Config.getDBUrl(), Config.getDBUser(), Config.getDBPassword());

			HttpSession session = request.getSession();
			
			boolean isLogined = false;
			int loginedMemberId = -1;
			String loginedMemberName = (String) session.getAttribute("loginedMemberName");
			
			if(session.getAttribute("loginedMemberLoginId") != null) {
				loginedMemberId = (int) session.getAttribute("loginedMemberId");
				isLogined = true;
			}
			
			request.setAttribute("isLogined", isLogined);
			request.setAttribute("loginedMemberId", loginedMemberId);
			request.setAttribute("loginedMemberName", loginedMemberName);
			
			int id = Integer.parseInt(request.getParameter("id")); 
			
			SecSql sql = SecSql.from("SELECT A.*, M.name AS writerName");
			sql.append("FROM article AS A");
			sql.append("INNER JOIN `member` AS M");
			sql.append("ON A.memberId = M.id");
			sql.append("WHERE A.id = ?", id);

			Map<String, Object> articleRow = DBUtil.selectRow(conn, sql);

			request.setAttribute("articleRow", articleRow);

			request.getRequestDispatcher("/jsp/article/detail.jsp").forward(request, response);

		} catch (SQLException e) {
			System.out.println("에러: " + e);
		} catch (SQLErrorException e) {
			e.getOrigin().printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
