package com.earth.najuhwa.dao;

import java.util.List;
import java.util.Map;

import com.earth.najuhwa.domain.SearchItem;
import com.earth.najuhwa.dto.BoardDTO;

public interface BoardDao {

	List<BoardDTO> selectPage(SearchItem sc) throws Exception;
	int insert(BoardDTO boardDTO);
	int count(SearchItem sc) throws Exception;
}
