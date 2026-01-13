package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.BoardMapper;
import com.sist.web.mapper.BoardReplyMapper;
import com.sist.web.vo.BoardVO;
import com.sist.web.vo.ReplyVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService, ReplyService {
	private final BoardMapper bMapper;
	private final BoardReplyMapper rMapper;

	@Override
	public List<BoardVO> boardListData(int start) {
		// TODO Auto-generated method stub
		return bMapper.boardListData(start);
	}

	@Override
	public int boardTotalPage() {
		// TODO Auto-generated method stub
		return bMapper.boardTotalPage();
	}

	@Override
	public void boardInsert(BoardVO vo) {
		// TODO Auto-generated method stub
		bMapper.boardInsert(vo);
	}

	@Override
	public BoardVO boardDetailData(int no) {
		// TODO Auto-generated method stub
		bMapper.boardHitIncrement(no);
		return bMapper.boardDetailData(no);
	}
	
	@Override
	public BoardVO boardUpdateData(int no) {
		return bMapper.boardDetailData(no);
	}

	@Override
	public String boardUpdate(BoardVO vo) {
		// TODO Auto-generated method stub
		String res="no";
		String db_pwd=bMapper.getBoardPassword(vo.getNo());
		if(db_pwd.equals(vo.getPwd()))
		{
			res="yes";
			bMapper.boardUpdate(vo);
		}
		return res;
	}

	@Override
	public boolean boardDelete(int no, String pwd) {
		// TODO Auto-generated method stub
		String db_pwd=bMapper.getBoardPassword(no);
		if(db_pwd.equals(pwd))
		{
			bMapper.boardDelete(no);
			return true;
		}	
		return false;
	}

	@Override
	public List<ReplyVO> replyListData(int bno) {
		// TODO Auto-generated method stub
		return rMapper.replyListData(bno);
	}
	
	@Override
	public int replyCount(int bno) {
		// TODO Auto-generated method stub
		int count=rMapper.replyCount(bno);
		bMapper.boardReplyCountUpdate(count, bno);
		return count;
	}

	@Override
	public void boardReplyInsert(ReplyVO vo) {
		// TODO Auto-generated method stub
		rMapper.boardReplyInsert(vo);
	}

	@Override
	public void boardReplyDelete(int no) {
		// TODO Auto-generated method stub
		rMapper.boardReplyDelete(no);
	}

	@Override
	public void boardReplyUpdate(ReplyVO vo) {
		// TODO Auto-generated method stub
		rMapper.boardReplyUpdate(vo);
	}
}
