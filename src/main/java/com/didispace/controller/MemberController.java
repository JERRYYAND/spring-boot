package com.didispace.controller;

import java.util.HashMap;
import java.util.Map;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.didispace.entity.MemberCard;
import com.didispace.producer.Producer;
import com.didispace.service.MemberCardService;

@RequestMapping("member/card")
@RestController
public class MemberController {
	@Autowired
	private MemberCardService memberCardService;
	@Autowired
	private Producer producer;
	
	/**
	 * 查询工人信息byId
	 * @author  xyl
	 */
	@RequestMapping(value="/get/info/id")
	@ResponseBody
	public MemberCard selectByPrimaryKey(@RequestParam String id){
		MemberCard memberCard = memberCardService.selectByPrimaryKey(id);
		return memberCard;
	}
	
	/**
	 * 查询工人信息byCardno
	 * @author  xyl
	 */
	@RequestMapping("/get/info/cardno")
	@ResponseBody
	public MemberCard queryByCardno(@RequestParam String cardno){
		MemberCard memberCard = memberCardService.queryByCardno(cardno);
		return memberCard;
	}
	/**
	 * activeMq 消息发送测试
	 * @author  xyl
	 */
	@RequestMapping("/activeMq")
	public void testActiveMq(){
		Destination destination=new ActiveMQQueue("boxVersionUpdateTopic_PTP");
		Map<String,Object> message = new HashMap<>();
		message.put("versionCode", 305);
		message.put("url", "http://lbz-test-storage.oss-cn-shenzhen.aliyuncs.com/lbz_pc_common/69fc19cab2d5481f92dca48349329dca.apk");
		producer.sendMessage(destination, message);
	}
	
	/**
	 * @param mqMessage
	 * @author  xyl
	 */
	@RequestMapping("/activeMq/message")
	public void testActiveMqMessage(){
		Destination destination=new ActiveMQQueue("mqMessage");
		for(int i=0;i<5;i++){
			producer.sendMessageTest(destination, "active MQ message");
		}
	}
	
	@JmsListener(destination="out.queue")
	public void consumerMessage(String text){
		System.out.println("从out.queue 队列收到的回复报文:"+text);
	}
	@RequestMapping("/topic/message")
	public void send(){
		for(int i=0;i<5;i++){
			producer.sendMessage();
		}
	}
}
