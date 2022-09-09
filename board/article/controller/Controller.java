package com.sbs.board.article.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Controller {

	public abstract String doAction(HttpServletRequest request, HttpServletResponse response, String action) throws IOException;

}