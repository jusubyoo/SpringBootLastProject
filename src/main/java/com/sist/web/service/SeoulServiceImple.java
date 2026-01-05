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
	public List<SeoulVO> seoulLocationListData(int start) {
		// TODO Auto-generated method stub
		return sMapper.seoulLocationListData(start);
	}

	@Override
	public int seoulLocationTotalPage() {
		// TODO Auto-generated method stub
		return sMapper.seoulLocationTotalPage();
	}
	
	
}
