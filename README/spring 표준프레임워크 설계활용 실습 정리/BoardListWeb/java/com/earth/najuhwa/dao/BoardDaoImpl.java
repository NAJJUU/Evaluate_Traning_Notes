package com.earth.najuhwa.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.earth.najuhwa.domain.SearchItem;
import com.earth.najuhwa.dto.BoardDTO;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private SqlSession session;
	private static String namespace = "com.earth.najuhwa.dao.BoardMapper.";

	@Override
	public List<BoardDTO> selectPage(SearchItem sc) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+"selectList", sc);
	}

	@Override
	public int insert(BoardDTO boardDTO) {
		return session.insert(namespace+"insert", boardDTO);
	}

	@Override
	public int count(SearchItem sc) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+"conut", sc);
	}
}
