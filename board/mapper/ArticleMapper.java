package com.sbs.board.mapper;

import java.util.List;
import java.util.Map;

import com.sbs.board.article.dao.Article;

public interface ArticleMapper {
	
	List<Article> getAllArticles();
	Article getArticleById(int id);
	void insertArticle(Map paramMap);
	void insertArticle2(Article article);
	List<Article> getAllArticles1();

}