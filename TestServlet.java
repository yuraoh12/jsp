package home.db;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jstl")
public class TestServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 포워딩
		
		String action = req.getParameter("action");
		
		if(action.equals("sol")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/sol.jsp");
			dispatcher.forward(req, resp);
			
		} else {

			ArrayList<String> slist = new ArrayList<>();
			
			for(int i = 1; i <= 10; i++) {
				slist.add("data" + i);
			}
			
			req.setAttribute("slist", slist);
					
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jstl-test.jsp");
			dispatcher.forward(req, resp);
		}
	}
	
}