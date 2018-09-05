package com.didispace.service;

import com.didispace.entity.MemberCard;

public interface MemberCardService {

	 MemberCard selectByPrimaryKey(String id);
	 
	 MemberCard queryByCardno(String cardno);
}
