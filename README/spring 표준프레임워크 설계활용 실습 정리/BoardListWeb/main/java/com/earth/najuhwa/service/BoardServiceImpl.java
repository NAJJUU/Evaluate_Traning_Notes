package com.earth.najuhwa.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.earth.najuhwa.dao.BoardDao;
import com.earth.najuhwa.domain.SearchItem;
import com.earth.najuhwa.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao boardDao;

	@Override
	public List<BoardDTO> getPage(SearchItem sc) throws Exception {
		return boardDao.selectPage(sc);
	}

	@Override
	public int write(BoardDTO boardDTO) throws Exception {
		return boardDao.insert(boardDTO);
	}

	@Override
	public int getCount(SearchItem sc) throws Exception {
		return boardDao.count(sc);
	}

}


