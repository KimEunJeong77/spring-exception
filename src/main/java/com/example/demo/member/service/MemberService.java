package com.example.demo.member.service;

import java.util.List;
import com.example.demo.member.dto.MemberDTO;

public interface MemberService {
	List<MemberDTO> findMemberList();
	MemberDTO findMemberDetail(String id);
	void login(String id, String pw);
}