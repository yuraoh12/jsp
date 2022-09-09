package com.sbs.board.article.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dao_Article {
	private int id;
	private String title;
	private String body;
}