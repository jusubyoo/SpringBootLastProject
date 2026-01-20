package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sist.web.mapper.CommonsReplyMapper;
import com.sist.web.vo.CommonsReplyVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommonsReplyServiceImpl implements CommonsReplyService {
	private final CommonsReplyMapper cMapper;

	@Override
	public List<CommonsReplyVO> commonsReplyListData(int cno, int start) {
		// TODO Auto-generated method stub
		return cMapper.commonsReplyListData(cno, start);
	}

	@Override
	public int commonsReplyTotalPage(int cno) {
		// TODO Auto-generated method stub
		return cMapper.commonsReplyTotalPage(cno);
	}

	@Override
	public void commonsReplyInsert(CommonsReplyVO vo) {
		// TODO Auto-generated method stub
		cMapper.commonsReplyInsert(vo);
	}

	@Override
	public void commonsMsgUpdate(CommonsReplyVO vo) {
		// TODO Auto-generated method stub
		cMapper.commonsMsgUpdate(vo);
	}

	@Override
	public void commonsDelete(int no) {
		// TODO Auto-generated method stub
		CommonsReplyVO vo=cMapper.commonsInfoData(no);
		if(vo.getGroup_step()==0)
		{
			cMapper.commonsAllDelete(vo.getGroup_id());
		}
		else
		{
			cMapper.commonsMyDelete(no);
		}
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void commonsReplyReplyInsert(CommonsReplyVO vo) {
		// TODO Auto-generated method stub
		int pno=vo.getNo(); // parent 번호
		CommonsReplyVO pvo=cMapper.commonsReplyParentData(pno);
		cMapper.commonsGroupStepIncrement(pvo);
		vo.setGroup_id(pvo.getGroup_id());
		vo.setGroup_step(pvo.getGroup_step()+1);
		vo.setGroup_tab(pvo.getGroup_tab()+1);
		vo.setRoot(pno);
		
		cMapper.commonsReplyReplyInsert(pvo);
		cMapper.commonsDepthIncrement(pno);
	}
}
