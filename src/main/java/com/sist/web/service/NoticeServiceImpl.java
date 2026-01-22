package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.NoticeMapper;
import com.sist.web.vo.NoticeVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {
	private final NoticeMapper nMapper;

	@Override
	public List<NoticeVO> noticeListData(int start) {
		// TODO Auto-generated method stub
		return nMapper.noticeListData(start);
	}

	@Override
	public int noticeTotalPage() {
		// TODO Auto-generated method stub
		return nMapper.noticeTotalPage();
	}

	@Override
	public void noticeInsert(NoticeVO vo) {
		// TODO Auto-generated method stub
		nMapper.noticeInsert(vo);
	}

	@Override
	public NoticeVO noticeDetailData(int no) {
		// TODO Auto-generated method stub
		nMapper.hitIncrement(no);
		return nMapper.noticeDetailData(no);
	}

	@Override
	public NoticeVO noticeFileInfoData(int no) {
		// TODO Auto-generated method stub
		return nMapper.noticeFileInfoData(no);
	}

	@Override
	public void noticeDelete(int no) {
		// TODO Auto-generated method stub
		nMapper.noticeDelete(no);
	}

	@Override
	public NoticeVO noticeUpdateData(int no) {
		// TODO Auto-generated method stub
		return nMapper.noticeDetailData(no);
	}

	@Override
	public void noticeUpdate(NoticeVO vo) {
		// TODO Auto-generated method stub
		nMapper.noticeUpdate(vo);
	}
}
