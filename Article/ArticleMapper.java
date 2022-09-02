package home.db.Article;

import java.util.ArrayList;
import java.util.Map;
public interface ArticleMapper {
	
	public Article selectArticle(int id);	
	public ArrayList<Article> selectArticleList();
	public void deleteArticle(int id);
	public void insertArticle(Map<String, Object> param);
	public void updateArticle(Map<String, Object> param);
	
}