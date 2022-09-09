package com.sbs.board.article.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sbs.board.Service;
import com.sbs.board.article.dao.Article;
import com.sbs.board.article.dao.ArticleDao;
import com.sbs.board.article.dao.Dao;

public class ArticleService {
	

	private Dao dao;
	
	public List<Article> getAllArticles() {
		return dao.getAllAritcles();
	}
	
	public void setDao(Dao dao) {
		this.dao = dao; 
	}

}