package com.didispace.dao;

import org.apache.ibatis.annotations.Param;

import com.didispace.entity.OaDeviceInfo;

public interface OaDeviceInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(OaDeviceInfo record);

    int insertSelective(OaDeviceInfo record);

    OaDeviceInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OaDeviceInfo record);

    int updateByPrimaryKey(OaDeviceInfo record);
    
    OaDeviceInfo queryDeviceByDeviceId(@Param("deviceId") String deviceId);
}