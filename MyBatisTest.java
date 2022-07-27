package home.db;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import home.db.article.ArticleMapper;

public class MyBatisTest {

	public static void main(String[] args) {
		
		String resource = "home/db/config.xml";
		InputStream inputStream;

		try {
			
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();
			
			ArticleMapper mapper = session.getMapper(ArticleMapper.class);		

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}