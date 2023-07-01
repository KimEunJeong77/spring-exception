package com.example.demo.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.member.exception.IdNotFoundException;
import com.example.demo.member.exception.PwMissMatchException;
import com.example.demo.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AuthController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/login/form")
	public ModelAndView loginForm() {
		ModelAndView mv=new ModelAndView("/loginForm");
		return mv;
	}	
	
	@ResponseBody
	@RequestMapping("/login")
	public Map<String,String> login(
			HttpServletRequest request, 
			@RequestParam  String id,
			@RequestParam  String pw
	) {
		log.info("==============   /login   =================");
		Map<String,String> map=new HashMap<>();
		memberService.login(id,pw);
		HttpSession session = request.getSession();
		session.setAttribute("id",id); 
		map.put("errorCode","0");
		return map;
	}


	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		log.info("==============  /logout   =================");
		HttpSession session = request.getSession();
		session.invalidate(); // 세션종료
		return new ModelAndView("redirect:" + request.getContextPath() + "/login/form");
	}
	
	 @ResponseBody
	 @ExceptionHandler({IdNotFoundException.class,PwMissMatchException.class})
	 public Map<String,String> loginException(Exception e) {
		 log.info("==============   loginException method   =================");
		 Map<String,String> map=new HashMap<>(); 
		 map.put("errorCode","-1");
		 map.put("errorMsg",e.getMessage()); 
		 return map; 
	 }
}