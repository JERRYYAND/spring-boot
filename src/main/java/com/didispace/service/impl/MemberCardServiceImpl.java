package com.didispace.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.didispace.dao.MemberCardMapper;
import com.didispace.entity.MemberCard;
import com.didispace.service.MemberCardService;

@Service("memberCardService")
public class MemberCardServiceImpl implements MemberCardService{
	
	@Autowired
	private MemberCardMapper  MemberCardMapper;
	@Override
	public MemberCard selectByPrimaryKey(String id) {
		MemberCard mc = MemberCardMapper.selectByPrimaryKey(id);
		return mc;
	}
	@Override
	public MemberCard queryByCardno(String cardno) {
		MemberCard mc = MemberCardMapper.querybyCardNo(cardno);
		return mc;
	}

}
