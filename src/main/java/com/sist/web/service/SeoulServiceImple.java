package com.sist.web.service;

import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.web.mapper.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SeoulServiceImple implements SeoulService {
	private final SeoulMapper sMapper;

	@Override
	public List<SeoulVO> seoulListData(Map map) {
		// TODO Auto-generated method stub
		return sMapper.seoulListData(map);
	}

	@Override
	public int seoulTotalPage(int contenttype) {
		// TODO Auto-generated method stub
		return sMapper.seoulTotalPage(contenttype);
	}

	@Override
	public SeoulVO seoulAttractionDetailData(int contentid) {
		// TODO Auto-generated method stub
		sMapper.seoulHitIncrement(contentid);
		return sMapper.seoulAttractionDetailData(contentid);
	}
}
