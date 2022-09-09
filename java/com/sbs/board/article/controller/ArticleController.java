package com.sbs.board.article.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sbs.board.Controller;
import com.sbs.board.Service;


public class ArticleController extends Controller {

	private Service service;
	
	public String doAction(HttpServletRequest request, HttpServletResponse response, String action) throws IOException {
		if(action.equals("list.do")) {
			
			request.setAttribute("articles", service.getAllArticles());
			return "/WEB-INF/list.jsp";
		} else {
			response.getWriter().println("잘못된 요청입니다.");
			return null;
		}
		
	}
	
	public void setService(Service service) {
		this.service = service;
	}
	
	
}