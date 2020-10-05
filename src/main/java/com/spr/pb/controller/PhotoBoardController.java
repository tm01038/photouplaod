package com.spr.pb.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spr.pb.service.PhotoBoardService;
import com.spr.pb.vo.PageVO;
import com.spr.pb.vo.PhotoBoardVO;

@Controller
public class PhotoBoardController {
	private static final Logger logger = LoggerFactory.getLogger(PhotoBoardController.class);
	
	@Autowired
	private PhotoBoardService photoBoardService;
		
	@GetMapping("/list")
	public @ResponseBody Map<String,Object> selectPhotoBoardList(PageVO page){
		PhotoBoardVO pb = new PhotoBoardVO();
		pb.setPage(page);
		Map<String,Object> rMap = new HashMap<>();
		rMap.put("result", photoBoardService.selectPhotoBoardList(pb));
		rMap.put("totalCnt",photoBoardService.totalCntPhotoBoard());
		return rMap;
	}
	@GetMapping("/select")
	@ResponseBody public PhotoBoardVO selectPhotoBoard(PhotoBoardVO pb){
		return photoBoardService.selectPhotoBoard(pb);
	}
	
	@PostMapping("/insert")
	@ResponseBody public Map<String,String> insertPhotoBoard(PhotoBoardVO pb,@RequestParam("file") MultipartFile file){
		System.out.println(pb);
		Map<String,String> rMap = new HashMap<>();
		rMap.put("msg","글쓰기 실패");
		if(photoBoardService.insertPhotoBoard(pb, file)==1) {
			rMap.put("msg","글쓰기 성공");
		}
		return rMap;
	}
	
	@PostMapping("/update")
	@ResponseBody public Map<String,String> updatePhotoBoard(PhotoBoardVO pb, @RequestParam("file") MultipartFile file){
		System.out.println(pb); 
		Map<String,String> rMap = new HashMap<>();
		rMap.put("msg","수정 실패");
		if(photoBoardService.updatePhotoBoard(pb, file)==1) {
			rMap.put("msg","수정 성공");
		}
		return rMap;
	}
	@PostMapping("/delete")
	@ResponseBody public Map<String,String> deletePhotoBoard(PhotoBoardVO pb){
		System.out.println(pb); 
		Map<String,String> rMap = new HashMap<>();
		rMap.put("msg","삭제 실패");
		if(photoBoardService.deletePhotoBoard(pb)==1) {
			rMap.put("msg","삭제 성공");
		}
		return rMap;
	}
}
