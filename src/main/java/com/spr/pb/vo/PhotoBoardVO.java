package com.spr.pb.vo;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@Component
@Alias("pbVO")
public class PhotoBoardVO {
	private int pbNum;
	private String pbTitle;
	private String pbContent;
	private String pbImgPath;
	private String credat;
	private String cretim;
	private PageVO page;
}
