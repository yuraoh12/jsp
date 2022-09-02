package home.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import home.db.article.ArticleMapper;
import home.db.member.MemberMapper;

public class DBUtil {

	public SqlSession getSession() {
		String resource = "home/db/config.xml";
		InputStream inputStream;
		SqlSession sqlSession = null;
		
		try {

			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();

		} catch (IOException e) {

			e.printStackTrace();
		}

		return sqlSession;
	}

	public ArticleMapper getArticleMapper() {

		SqlSession session = getSession();
		ArticleMapper mapper = null;
		
		if(session != null) {
			session.getMapper(ArticleMapper.class);			
		}
	
		return mapper;

	}

	public MemberMapper getMemberMapper() {
		SqlSession session = getSession();
		MemberMapper mapper = null;
		
		if(session != null) {
			session.getMapper(MemberMapper.class);			
		}
	
		return mapper;

	}