package com.didispace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.didispace.service.OaDeviceInfoService;

@RequestMapping("device")
@RestController
public class OaDeviceInfoController {

	@Autowired
	private OaDeviceInfoService  oaDeviceInfoService;
	
	@RequestMapping(value="/info")
	public String getDeviceInfo(@RequestBody String  body){
		JSONObject jsonObject = JSONObject.parseObject(body);
		JSONObject json = (JSONObject)jsonObject.get("data");
		String versionName = json.getString("versionName");
		Integer personNumber = json.getInteger("personNumber");
		Integer attendanceNumber = json.getInteger("attendanceNumber");
		Long overplusStoragerl = json.getLong("overplusStorager");
		String overplusStorager = String.valueOf(overplusStoragerl);
		oaDeviceInfoService.saveDeviceInfo(versionName, personNumber, attendanceNumber, overplusStorager);
		return "success";
	}
	
}
