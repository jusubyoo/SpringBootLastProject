package com.sist.web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sist.web.mapper.MemberMapper;
import com.sist.web.vo.MemberVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	private final MemberMapper mMapper;

	@Override
	public int idCheck(String userid) {
		// TODO Auto-generated method stub
		return mMapper.idCheck(userid);
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class) // 둘 중 하나가 실패하면 회원가입 취소
	public void memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		mMapper.memberInsert(vo);
	}

	@Override
	public void memberAuthorityInsert(String userid) {
		// TODO Auto-generated method stub
		mMapper.memberAuthorityInsert(userid);
	}

	@Override
	public MemberVO memberInfoData(String userid) {
		// TODO Auto-generated method stub
		return mMapper.memberInfoData(userid);
	}
}
