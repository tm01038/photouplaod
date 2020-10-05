package com.spr.pb.dao;

import java.util.List;

import com.spr.pb.vo.PhotoBoardVO;

public interface PhotoBoardDAO {
	List<PhotoBoardVO> selectPhotoBoardList(PhotoBoardVO pb);
	PhotoBoardVO selectPhotoBoard(PhotoBoardVO pb);
	int insertPhotoBoard(PhotoBoardVO pb);
	int updatePhotoBoard(PhotoBoardVO pb);
	int deletePhotoBoard(PhotoBoardVO pb);
	int totalCntPhotoBoard();
}
