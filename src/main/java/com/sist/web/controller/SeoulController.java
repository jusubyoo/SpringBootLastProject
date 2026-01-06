package com.sist.web.controller;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.web.service.*;
import com.sist.web.vo.*;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SeoulController {
	private final SeoulService sService;
	
	@GetMapping("/seoul/list")
	public String seoul_location(@RequestParam(name="page",required = false) String page, @RequestParam("cno") int cno, Model model)
	{
		// include 가 되는 파일을 올린다 => request 를 공유할 수 있다
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		map.put("start", (curpage-1)*12);
		map.put("contenttype", cno);
		
		List<SeoulVO> list=sService.seoulListData(map);
		int totalpage=sService.seoulTotalPage(cno);
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage) 
			endPage=totalpage;
		
		String name="";
		if(cno==12) name="서울 관광지";
		else if(cno==14) name="서울 문화시설";
		else if(cno==15) name="서울 축제 & 공연";
		else if(cno==32) name="서울 숙박";
		else if(cno==38) name="서울 쇼핑";
		else if(cno==39) name="서울 음식";
		
		String name1="";
		if(cno==12) name1="관광지";
		else if(cno==14) name1="문화시설";
		else if(cno==15) name1="축제 & 공연";
		else if(cno==32) name1="숙박";
		else if(cno==38) name1="쇼핑";
		else if(cno==39) name1="음식";
		
		for(SeoulVO vo:list)
		{
			String[] addrs=vo.getAddress().split(" ");
			vo.setAddress(addrs[1]+" "+addrs[2]);
		}
		
		model.addAttribute("name", name);
		model.addAttribute("name1", name1);
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("cno", cno);
		
		model.addAttribute("main_jsp", "../seoul/list.jsp");
		return "main/main";
	}
	/*
	 * 	sendRedirect : RedirectAttributes
	 *  forward : Model (HttpServletRequest 포함)
	 */
	@GetMapping("/seoul/detail_before")
	public String seoul_detail_before(@RequestParam("contentid") int contentid, @RequestParam("contenttype") int contenttype, 
									  HttpServletResponse response, RedirectAttributes ra)
	{
		Cookie cookie=new Cookie("seoul_"+contentid, String.valueOf(contentid));
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		
		ra.addAttribute("contentid", contentid);
		ra.addAttribute("contenttype", contenttype);
		return "redirect:/seoul/detail";
	}
	
	@GetMapping("/seoul/detail")
	public String seoul_detail(@RequestParam("contentid") int contentid, @RequestParam("contenttype") int contenttype, Model model)
	{
		String name="";
		if(contenttype==12) name="관광지";
		else if(contenttype==14) name="문화시설";
		else if(contenttype==15) name="축제 & 공연";
		else if(contenttype==32) name="숙박";
		else if(contenttype==38) name="쇼핑";
		else if(contenttype==39) name="음식";
		
		String jsp="";
		if(contenttype==12)
		{
			SeoulVO vo=sService.seoulAttractionDetailData(contentid);
			model.addAttribute("vo", vo);
			jsp="../seoul/attraction.jsp";
		}
		else if(contenttype==14)
		{
			jsp="../seoul/culture.jsp";
		}
		else if(contenttype==15)
		{
			jsp="../seoul/festival.jsp";
		}
		else if(contenttype==32)
		{
			jsp="../seoul/stay.jsp";
		}
		else if(contenttype==38)
		{
			jsp="../seoul/shopping.jsp";
		}
		else if(contenttype==39)
		{
			jsp="../seoul/food_store.jsp";
		}
		model.addAttribute("name", name);
		model.addAttribute("main_jsp", jsp);
		return "main/main";
	}
	
	// 화면 이동 => 데이터처리 (RestController)
	@GetMapping("/seoul/find")
	public String seoul_find(Model model)
	{
		model.addAttribute("main_jsp", "../seoul/seoul_find.jsp");
		return "main/main";
	}
}
