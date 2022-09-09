package com.sbs.board.member.controller;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sbs.board.Controller;
import com.sbs.board.member.service.MemberService;

public class MemberController extends Controller {
	
	MemberService service= new MemberService();
	
	public MemberController(HttpServletRequest request, HttpServletResponse response, String action) {
		super();
	}

	public String doAction() throws IOException {
		Object action;
		if(action.equals("list.do")) {
			ServletRequest request;
			request.setAttribute("article", service.getAllMembers());
			return "/WEB-INF/list.jsp";
		} else {
			ServletResponse response;
			response.getWriter().println("잘못된 요청입니다.");
		return null;
		}
	}

	@Override
	public String doAction(HttpServletRequest request, HttpServletResponse response, String action) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
}