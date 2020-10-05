package com.spr.pb.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spr.pb.dao.PhotoBoardDAO;
import com.spr.pb.vo.PhotoBoardVO;

@Repository
public class PhotoBoardDAOImpl implements PhotoBoardDAO {

@Autowired
private SqlSessionFactory ssf;

	
	@Override
	public List<PhotoBoardVO> selectPhotoBoardList(PhotoBoardVO pb) {
		try(SqlSession ss = ssf.openSession()){
			return ss.selectList("Pb.selectPhotoBoardList",pb);
		}
	}

	@Override
	public PhotoBoardVO selectPhotoBoard(PhotoBoardVO pb) {
		try(SqlSession ss = ssf.openSession()){
			return ss.selectOne("Pb.selectPhotoBoard",pb);
		}
	}

	@Override
	public int insertPhotoBoard(PhotoBoardVO pb) {
		try(SqlSession ss = ssf.openSession()){
			return ss.insert("Pb.insertPhotoBoard",pb);
		}
	}

	@Override
	public int updatePhotoBoard(PhotoBoardVO pb) {
		try(SqlSession ss = ssf.openSession()){
			return ss.update("Pb.updatePhotoBoard",pb);
		}
	}

	@Override
	public int deletePhotoBoard(PhotoBoardVO pb) {
		try(SqlSession ss = ssf.openSession()){
			return ss.delete("Pb.deletePhotoBoard",pb);
		}
	}

	@Override
	public int totalCntPhotoBoard() {
		try(SqlSession ss = ssf.openSession()){
			return ss.selectOne("Pb.totalCntPhotoBoard");
		}
	}

}
