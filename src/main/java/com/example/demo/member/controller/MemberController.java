package com.example.demo.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping("/member/list")
	public ModelAndView memberList() {
		log.info("========================== MemberController(/member/list) ==================================");
		ModelAndView mv=new ModelAndView("/member/list");
		List<MemberDTO> list=memberService.findMemberList();
		mv.addObject("list", list);
		return mv;
	}
	
}
