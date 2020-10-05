package com.spr.pb;

import static org.junit.Assert.assertNull;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spr.pb.dao.PhotoBoardDAO;
import com.spr.pb.vo.PhotoBoardVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class StartTest {
	
	private static final Logger logger = LoggerFactory.getLogger(StartTest.class);
	@Autowired
	private PhotoBoardDAO dao;
	@Autowired
	private PhotoBoardVO pb;
	
	
	@Test
	public void test() {
		pb.setPbContent("tlqkf");
		pb.setPbNum(2);
		logger.info("{}",dao.totalCntPhotoBoard());
	}
}
