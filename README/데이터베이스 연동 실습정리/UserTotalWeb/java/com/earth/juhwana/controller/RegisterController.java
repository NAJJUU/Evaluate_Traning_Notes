package com.earth.juhwana.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.earth.juhwana.dao.UserDao;
import com.earth.juhwana.domain.User;

import jakarta.validation.Valid;

@Controller
public class RegisterController {
	
	@Autowired
	UserDao userDao;
	
	@GetMapping("/register")
	public String register() {
		return "registerForm";
	}
	
	@PostMapping("/register")
	public String registerPost(@Valid User user, BindingResult result, Model m) throws UnsupportedEncodingException {
		//DB에 새로운 회원 정보를 저장
		if(!result.hasErrors()) {
			int rowCnt = userDao.insert(user);
			if(rowCnt != 0) return "redirect:/loginForm";
		}		
		return "redirect:/register";
	}
}
