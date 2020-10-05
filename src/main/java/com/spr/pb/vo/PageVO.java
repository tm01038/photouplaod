package com.spr.pb.vo;

import lombok.Data;

@Data
public class PageVO {
	private int startNum;
	private int endNum;
	private int startBlock;
	private int endBlock;
	private int page;
	private int totalPage;
}
