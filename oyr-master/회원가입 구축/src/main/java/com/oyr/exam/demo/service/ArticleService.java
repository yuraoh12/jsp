package com.oyr.exam.demo.service;

import java.util.List;

import com.oyr.exam.demo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oyr.exam.demo.util.Utility;
import com.oyr.exam.demo.vo.Article;
import com.oyr.exam.demo.vo.ResultData;

@Service
public class ArticleService {
	
	private ArticleRepository articleRepository;
	
	@Autowired
	public ArticleService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	public Article getArticle(int id) {
		return articleRepository.getArticle(id);
	}

	public void deleteArticle(int id) {
		articleRepository.deleteArticle(id);
	}

	public void modifyArticle(int id, String title, String body) {
		articleRepository.modifyArticle(id, title, body);
	}

	public List<Article> getArticles(int boardId, String searchKeywordTypeCode, String searchKeyword, int itemsInAPage, int page) {
		
		int limitStart = (page - 1) * itemsInAPage;
		
		return articleRepository.getArticles(boardId, searchKeywordTypeCode, searchKeyword, limitStart, itemsInAPage);
	}

	public ResultData<Integer> writeArticle(int memberId, int boardId, String title, String body) {
		articleRepository.writeArticle(memberId, boardId, title, body);
		int id = articleRepository.getLastInsertId();
		return ResultData.from("S-1", Utility.f("%d번 게시물이 생성되었습니다", id), "id", id);
	}

//	public ResultData actorCanModify(int loginedMemberId, Article article) {
//		
//		if(loginedMemberId != article.getMemberId()) {
//			return ResultData.from("F-B", "해당 게시물에 대한 권한이 없습니다");
//		}
//		
//		return ResultData.from("S-1", "수정 가능");
//	}
//	
//	public ResultData actorCanDelete(int loginedMemberId, Article article) {
//		
//		if(article == null) {
//			return ResultData.from("F-1", Utility.f("해당 게시물은 존재하지 않습니다"));
//		}
//		
//		if(loginedMemberId != article.getMemberId()) {
//			return ResultData.from("F-B", "해당 게시물에 대한 권한이 없습니다");
//		}
//		
//		return ResultData.from("S-1", "삭제 가능");
//	}
	
	public ResultData actorCanMD(int loginedMemberId, Article article) {
		
		if(article == null) {
			return ResultData.from("F-1", Utility.f("해당 게시물은 존재하지 않습니다"));
		}
		
		if(loginedMemberId != article.getMemberId()) {
			return ResultData.from("F-B", "해당 게시물에 대한 권한이 없습니다");
		}
		
		return ResultData.from("S-1", "가능");
	}
	
	public Article getForPrintArticle(int loginedMemberId, int id) {
		
		Article article = articleRepository.getForPrintArticle(id);
		
		actorCanChangeData(loginedMemberId, article);
		
		return article;
	}

	private void actorCanChangeData(int loginedMemberId, Article article) {
		if(article == null) {
			return;
		}
		
		ResultData actorCanChangeDataRd = actorCanMD(loginedMemberId, article);
		article.setActorCanChangeData(actorCanChangeDataRd.isSuccess());
		
	}

	public int getArticlesCount(int boardId, String searchKeywordTypeCode, String searchKeyword) {
		return articleRepository.getArticlesCount(boardId, searchKeywordTypeCode, searchKeyword);
	}

	public ResultData<Integer> increaseHitCount(int id) {
		int affectedRowsCount = articleRepository.increaseHitCount(id);
		
		if(affectedRowsCount == 0) {
			return ResultData.from("F-1", "해당 게시물은 존재하지 않습니다", "affectedRowsCount", affectedRowsCount);
		}
		
		return ResultData.from("S-1", "조회수 증가", "affectedRowsCount", affectedRowsCount);
	}

	public int getArticleHitCount(int id) {
		return articleRepository.getArticleHitCount(id);
	}
}