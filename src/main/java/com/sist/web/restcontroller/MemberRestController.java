package com.sist.web.restcontroller;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.service.*;

@RestController
@RequiredArgsConstructor
public class MemberRestController {
	private final MemberService mService;
	
	@GetMapping("/member/idCheck_vue/")
	public String member_idcheck_vue(@RequestParam("userid") String userid)
	{
		int count=mService.idCheck(userid);
		return String.valueOf(count);
	}
}
