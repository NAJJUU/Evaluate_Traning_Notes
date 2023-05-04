package com.earth.najuhwa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.earth.najuhwa.domain.PageResolver;
import com.earth.najuhwa.domain.SearchItem;
import com.earth.najuhwa.dto.BoardDTO;
import com.earth.najuhwa.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;

	@GetMapping("/board")
	public String board(HttpServletRequest request, SearchItem sc, Model m) {
				
		if(!loginCheck(request)) {
			return "redirect:/loginForm?toURL="+request.getRequestURL();
		}
		
		try {
			int totalCnt = boardService.getCount(sc);
			m.addAttribute("totalCnt", totalCnt);
			
			PageResolver pageResolver =  new PageResolver(totalCnt, sc);
			
			List<BoardDTO> list = boardService.getPage(sc);
			m.addAttribute("list", list);
			m.addAttribute("pr", pageResolver);
			
		} catch (Exception e) {e.printStackTrace();}
		
		return "boardList";
	}
	
	private boolean loginCheck(HttpServletRequest request) {
		//1. 세션을 얻어서(false는 session이 없어도 새로 생성하지 않음, 반환값은 null)
		HttpSession session = request.getSession(false);
		//2. 세션에 id가 있는지 확인, 있으면 true를 반환
		return session != null && session.getAttribute("id") != null;
	}
}
