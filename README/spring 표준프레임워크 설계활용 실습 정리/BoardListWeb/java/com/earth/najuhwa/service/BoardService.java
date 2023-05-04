package com.earth.najuhwa.service;

import java.util.List;
import java.util.Map;

import com.earth.najuhwa.domain.SearchItem;
import com.earth.najuhwa.dto.BoardDTO;

public interface BoardService {

	List<BoardDTO> getPage(SearchItem sc) throws Exception;
	int write(BoardDTO boardDTO) throws Exception;
	int getCount(SearchItem sc) throws Exception;
}
