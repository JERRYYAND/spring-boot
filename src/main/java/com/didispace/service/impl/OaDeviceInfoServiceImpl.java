package com.didispace.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.didispace.dao.OaDeviceInfoMapper;
import com.didispace.entity.OaDeviceInfo;
import com.didispace.service.OaDeviceInfoService;
import com.didispace.uitl.IdGen;

@Service("oaDeviceInfoService")
public class OaDeviceInfoServiceImpl implements OaDeviceInfoService{

	@Autowired
	private OaDeviceInfoMapper oaDeviceInfoMapper;
	
	@Override
	public void saveDeviceInfo(String versionName,Integer personNumber,Integer attendanceNumber,String overplusStorager) {
		String deviceId="CG1806JBW0A0025";
		OaDeviceInfo odi = oaDeviceInfoMapper.queryDeviceByDeviceId(deviceId);
		if(odi!=null){
			setDeviceInfo(odi,deviceId, versionName, personNumber, attendanceNumber, overplusStorager);
			oaDeviceInfoMapper.updateByPrimaryKeySelective(odi);	
		}else{
			odi=new OaDeviceInfo();
			odi.setId(IdGen.uuid());
			odi.setCreateTime(new Date());
			setDeviceInfo(odi,deviceId, versionName, personNumber, attendanceNumber, overplusStorager);
			oaDeviceInfoMapper.insertSelective(odi);
		}
		
	}
	/**
	 * 设置属性值
	 * @author  xyl
	 */
	private  void setDeviceInfo(OaDeviceInfo odi,String deviceId,String versionName,Integer personNumber,Integer attendanceNumber,String overplusStorager){
		odi.setDeviceId(deviceId);
		odi.setVersionname(versionName);
		odi.setPersonnumber(personNumber);
		odi.setAttendancenumber(attendanceNumber);
		odi.setOverplusstorager(overplusStorager);
		odi.setUpdateTime(new Date());
	}

}
