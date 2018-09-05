package com.didispace.dao;

import org.apache.ibatis.annotations.Param;

import com.didispace.entity.MemberCard;

public interface MemberCardMapper {
    int deleteByPrimaryKey(String id);

    int insert(MemberCard record);

    int insertSelective(MemberCard record);

    MemberCard selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MemberCard record);

    int updateByPrimaryKey(MemberCard record);
    
    MemberCard querybyCardNo(@Param("cardno") String cardno);
}