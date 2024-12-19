package com.smhrd.entity;

import lombok.Data;

@Data
public class Board {

	private String title;
	
	private String writer;
	
	private String content;

	private String img;

	private String indate;
	
	private int count;
	
	private int idx;
	
	
}
//dto는 이렇게 해주면 된다!