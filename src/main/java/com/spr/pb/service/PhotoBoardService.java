package com.spr.pb.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.spr.pb.vo.PhotoBoardVO;

public interface PhotoBoardService {
	List<PhotoBoardVO> selectPhotoBoardList(PhotoBoardVO pb);
	PhotoBoardVO selectPhotoBoard(PhotoBoardVO pb);
	int insertPhotoBoard(PhotoBoardVO pb, MultipartFile file);
	int updatePhotoBoard(PhotoBoardVO pb, MultipartFile file);
	int deletePhotoBoard(PhotoBoardVO pb);
	int totalCntPhotoBoard();
}
