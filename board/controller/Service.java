package com.sbs.board.controller;

import java.util.List;

import com.sbs.board.article.dao.Article;
import com.sbs.board.article.dao.Dao;

public interface Service {
	
	List<Article> getAllArticles1();
	void setDao(Dao dao);
	Object getAllArticles();
}