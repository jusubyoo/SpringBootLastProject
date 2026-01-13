package com.sist.web.service;

import java.util.List;
import com.sist.web.vo.ReplyVO;

public interface ReplyService {
	public List<ReplyVO> replyListData(int bno);
	public int replyCount(int bno);
	public void boardReplyInsert(ReplyVO vo);
	public void boardReplyDelete(int no);
	public void boardReplyUpdate(ReplyVO vo);
}
