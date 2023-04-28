package com.earth.juhwana.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.earth.juhwana.dao.UserDao;
import com.earth.juhwana.domain.User;


@Controller
public class LoginController {
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping("/index")
	public String main() {		
		return "index";
	}
	
	@GetMapping("/loginForm")
	public String login() {	
		return "loginForm";
	}
	
	@PostMapping("/loginForm")
	public String login(String id, String pwd, 
			HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		
		//1. id와 pw를 확인
		if(!loginCheck(id, pwd)) {
			//2-1. 일치하지 않으면, loginForm으로 이동
			String msg = URLEncoder.encode("id 또는 비밀번호가 일치하지 않습니다.", "utf-8");
			return "redirect:/loginForm?msg="+msg;
		}
		
		//2-2. 일치하면 쿠키 생성
		Cookie cookie = new Cookie("id", id);
		response.addCookie(cookie);
			
		//3. 세션
		//	세션 객체 얻어오기
		HttpSession session = request.getSession();
		//	세션 객체에 id를 저장
		session.setAttribute("id", id);
			
		return "index";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//세션 종료
		session.invalidate();
		//홈으로 이동
		return "redirect:/";
	}
	
	private boolean loginCheck(String id, String pwd) {
		User user = userDao.select(id);
		if(user == null) return false;
		return user.getPwd().equals(pwd);
	}
}




