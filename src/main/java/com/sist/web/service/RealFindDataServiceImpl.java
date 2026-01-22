package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.RealFindDataMapper;
import com.sist.web.vo.RealFindDataVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RealFindDataServiceImpl implements RealFindDataService {
	private final RealFindDataMapper rMapper;

	@Override
	public void realFindDataInsert(RealFindDataVO vo) {
		// TODO Auto-generated method stub
		rMapper.realFindDataInsert(vo);
	}

	@Override
	public void realFindDataDelete() {
		// TODO Auto-generated method stub
		rMapper.realFindDataDelete();
	}

	@Override
	public List<RealFindDataVO> realFindDataAllData() {
		// TODO Auto-generated method stub
		return rMapper.realFindDataAllData();
	}
}
