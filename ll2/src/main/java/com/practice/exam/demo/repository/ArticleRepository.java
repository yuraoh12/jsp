package com.cjh.exam.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cjh.exam.demo.vo.Article;

@Mapper
public interface ArticleRepository {

	public void writeArticle(String title, String body);

	public Article getArticle(int id);

	public List<Article> getArticles();
	
	public void deleteArticle(int id);

	public void modifyArticle(int id, String title, String body);

	public int getLastInsertId();
}
