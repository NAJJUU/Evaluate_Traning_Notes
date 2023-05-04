package com.earth.najuhwa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.earth.najuhwa.dao.BoardDao;
import com.earth.najuhwa.dto.BoardDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class insertTest {
	
	@Autowired
	private BoardDao boardDao;
	
	@Test
	public void insertDummyTestData() throws Exception{
		
		for(int i=1; i <= 250; i++) {
			BoardDTO boardDTO = new BoardDTO("title"+i, "content", "earth"+i);
			boardDao.insert(boardDTO);			
		}
	}

}
