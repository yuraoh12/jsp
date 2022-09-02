package home.db;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resources;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import home.db.Article.Article;
import home.db.Article.ArticleMapper;

public class MyBatisTest {

	public static void main(String[] args) {
		
		String resource = "home/db/config.xml";
		InputStream inputStream;

		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();
		
			//2. 매퍼설정.
			ArticleMapper mapper = session.getMapper(ArticleMapper.class);		
			Article article = mapper.selectBlog(101);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}