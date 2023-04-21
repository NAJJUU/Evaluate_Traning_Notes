package com.earth.screen;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
class Exception400 extends RuntimeException{
	
	public Exception400(String msg) {
		super(msg);
	}
	
	public Exception400() {
		this("");
	}
}

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
class Exception500 extends RuntimeException{
	public Exception500(String msg) {
		super(msg);
	}
	
	public Exception500() {
		this("");
	}
}

@Controller
public class SharedExceptionController {
	
	@RequestMapping("/error400")
	public String earth(Model m) {
		throw new Exception400("사용자 정의 예외가 발생했습니다.");
	}
	
	@RequestMapping("/error500")
	public String earth2(Model m) {
		throw new Exception500("사용자 정의 예외가 발생했습니다.");
	}

}



