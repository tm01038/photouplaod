package com.spr.pb.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.spr.pb.dao.PhotoBoardDAO;
import com.spr.pb.service.PhotoBoardService;
import com.spr.pb.vo.PageVO;
import com.spr.pb.vo.PhotoBoardVO;

@Service
public class PhotoBoardServiceImpl implements PhotoBoardService {

	@Autowired
	private PhotoBoardDAO photoBoardDAO;

	@Override
	public List<PhotoBoardVO> selectPhotoBoardList(PhotoBoardVO pb) {
		PageVO page = pb.getPage();
		if(page.getPage() == 0) {
			page = new PageVO();
			page.setPage(1);
		}
		int pageNum = page.getPage();
		int startNum=((pageNum-1)*10)+1;
		int endNum = startNum+9;
		page.setStartNum(startNum);
		page.setEndNum(endNum);
		pb.setPage(page);
		return photoBoardDAO.selectPhotoBoardList(pb);
	}

	@Override
	public PhotoBoardVO selectPhotoBoard(PhotoBoardVO pb) {
		return photoBoardDAO.selectPhotoBoard(pb);
	}

	@Override
	public int insertPhotoBoard(PhotoBoardVO pb, MultipartFile file) {
		String pbPhotoPath = "D:\\java_study\\workspace\\homework01\\src\\main\\webapp\\resources\\img\\";
		String pbImgPath = System.nanoTime()+"";
		System.out.println(file.getSize());
		if (file.getSize() != 0) {
			pb.setPbImgPath(pbImgPath);
			File f = new File(pbPhotoPath+pbImgPath);
			try {
				file.transferTo(f);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return photoBoardDAO.insertPhotoBoard(pb);
	}

	@Override
	public int updatePhotoBoard(PhotoBoardVO pb , MultipartFile file) {
		String pbPhotoPath = "D:\\java_study\\workspace\\homework01\\src\\main\\webapp\\resources\\img\\";
		
		if (file.getSize() != 0) {
			String pbImgPath = System.nanoTime()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			PhotoBoardVO oldFile = photoBoardDAO.selectPhotoBoard(pb);
			String oldPbImgPath = oldFile.getPbImgPath();
			File f = new File(pbPhotoPath+oldPbImgPath);
			if(f.exists()) {
				if(f.delete()) {
					f= new File(pbPhotoPath+pbImgPath);
					try {
						pb.setPbImgPath(pbImgPath);
						file.transferTo(f);
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}else {
				f= new File(pbPhotoPath+pbImgPath);
				try {
					pb.setPbImgPath(pbImgPath);
					file.transferTo(f);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return photoBoardDAO.updatePhotoBoard(pb);
	}

	@Override
	public int deletePhotoBoard(PhotoBoardVO pb) {
		return photoBoardDAO.deletePhotoBoard(pb);
	}

	@Override
	public int totalCntPhotoBoard() {
		return photoBoardDAO.totalCntPhotoBoard();
	}

}
