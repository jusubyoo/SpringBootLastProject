package com.sist.web.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.service.CommonsReplyService;
import com.sist.web.vo.CommonsReplyVO;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CommonsReplyRestController {
	// private String[] table_name= {"","seoultravel","busantravel","jejutravel"};
	private final CommonsReplyService cService;
	
	public Map commonsData(int page, int cno) 
	{
		Map map=new HashMap();
		// DB 연동
		List<CommonsReplyVO> list=cService.commonsReplyListData(cno, (page-1)*10);
		int totalpage=cService.commonsReplyTotalPage(cno);
		final int BLOCK=5;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		map.put("list", list);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("cno", cno);
		map.put("count", list.size());
		return map;
	}
	
	@GetMapping("/commons/list_vue/")
	public ResponseEntity<Map> commons_list_vue(@RequestParam("page") int page,@RequestParam("cno") int cno)
	{
		Map map=new HashMap();
		try
		{
			map=commonsData(page, cno);
		}catch(Exception ex)
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@PostMapping("/commons/insert_vue/")
	public ResponseEntity<Map> commonst_insert_vue(@RequestBody CommonsReplyVO vo, HttpSession session)
	{
		Map map=new HashMap();
		try
		{
			String id=(String)session.getAttribute("userid");
			String name=(String)session.getAttribute("username");
			String sex=(String)session.getAttribute("sex");
			vo.setId(id);
			vo.setName(name);
			vo.setSex(sex);
			cService.commonsReplyInsert(vo);
			map=commonsData(vo.getPage(), vo.getCno());
		}catch(Exception ex)
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@DeleteMapping("/commons/delete_vue/")
	public ResponseEntity<Map> commons_delete_vue(@RequestParam("page") int page,@RequestParam("cno") int cno,
			@RequestParam("no") int no)
	{
		Map map=new HashMap();
		try
		{
			cService.commonsDelete(no);
			map=commonsData(page, cno);
		}catch(Exception ex)
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@PutMapping("/commons/update_vue/")
	public ResponseEntity<Map> commons_update(@RequestBody CommonsReplyVO vo)
	{
		Map map=new HashMap();
		try
		{
			cService.commonsMsgUpdate(vo);
			map=commonsData(vo.getPage(), vo.getCno());
		}catch(Exception ex)
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@PostMapping("/commons/reply_reply_insert_vue/")
	public ResponseEntity<Map> commons_reply_reply(@RequestBody CommonsReplyVO vo,HttpSession session)
	{
		Map map=new HashMap();
		try
		{
			String id=(String)session.getAttribute("id");
			String sex=(String)session.getAttribute("sex");
			String name=(String)session.getAttribute("name");
			vo.setId(id);
			vo.setSex(sex);
			vo.setName(name);
			cService.commonsReplyReplyInsert(vo);
			map=commonsData(vo.getPage(), vo.getCno());
		}catch(Exception ex)
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}
