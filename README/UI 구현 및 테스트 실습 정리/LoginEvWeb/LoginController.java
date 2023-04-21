package com.earth.screen;

import java.io.UnsupportedEncodingException;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/index")
	public String main() {		
		return "index";
	}
	
	@GetMapping("/loginForm")
	public String register() {	
		return "loginForm";
	}
	
	@PostMapping("/loginForm")
	public String login(String id, String pwd, String toURL, 
			HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		
		//2-2. 일치하면 로그인 후 화면(홈) 이동
		if(id != null && pwd != null) {
			//2-2-1. 쿠키를 생성
			//2-2-2. 응답헤더에 저장(addCookie)
			Cookie cookie = new Cookie("id", id);
			response.addCookie(cookie);
			
		}else {
			//2-3-1. 쿠키를 삭제
			//2-3-2. 응답헤더에 저장(addCookie)
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		//3. 세션
		//	세션 객체 얻어오기
		HttpSession session = request.getSession();
		//	세션 객체에 id를 저장
		session.setAttribute("id", id);
		
		//4. 뷰 이동
		toURL = toURL==null || toURL.equals("") ? "/" : toURL;		
		return "redirect:"+toURL;
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//세션 종료
		session.invalidate();
		//홈으로 이동
		return "redirect:/";
	}
}




