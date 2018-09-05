package com.didispace.controller;

import java.util.HashMap;
import java.util.Map;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@RestController
public class IndexControl {
	
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	
//	@Autowired
//	private ActivemqMsgRepository activemqMsgRepository;
	
	@RequestMapping(value="/")
	public Object index(){
		/*ActiveMQTextMessage message = new ActiveMQTextMessage();
		try {
			message.setText("message1");
			message.setAcknowledgeCallback(new Callback() {
				@Override
				public void execute() throws Exception {
					System.out.println("########### Callback111 ");
				}
			});
			message.setCorrelationId("lbz1");
			message.setJMSCorrelationID("lbz");
			message.setStringProperty("clientId", "lbz");
		} catch (MessageNotWriteableException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		//jmsMessagingTemplate.convertAndSend(new ActiveMQTopic("topic1"), message);
		//jmsMessagingTemplate.convertAndSend(new ActiveMQTopic("topic2"), "topic2");
		//jmsMessagingTemplate.convertAndSend(new ActiveMQTopic("topic3"), "topic3");
		
		try {
			message.setText("mqtt.2");
			message.setStringProperty("clientId", "AndroidClient");
		} catch (Exception e) {
			e.printStackTrace();
		}
		jmsMessagingTemplate.convertAndSend(new ActiveMQTopic("p2p.topic.mqtt.1"), message);
		
		try {
			message.setText("queue1");
		} catch (MessageNotWriteableException e) {
			e.printStackTrace();
		}*/
		//jmsMessagingTemplate.convertAndSend(new ActiveMQQueue("queue1"), message);
		//jmsMessagingTemplate.convertAndSend(new ActiveMQQueue("queue2"), "queue2");
		jmsMessagingTemplate.getJmsTemplate().send("boxVersionUpdateTopic_PTP", new MessageCreator(){
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMsg = session.createTextMessage("{\"versionCode\":"+105+",\"url\":\"http://app.lubanzhang.com.cn/box/lbz_box_105.apk\"}");
				textMsg.setJMSDeliveryMode(DeliveryMode.PERSISTENT);
				textMsg.setStringProperty("clientId", "GB8ZANCDH0");
				return textMsg;
			}
		});
//		return activemqMsgRepository.findAll();
		return null;
	}
	
	@RequestMapping(value="boxUpdate/{clientId}")
	public Object boxUpdate(@PathVariable("clientId") final String clientId){
		jmsMessagingTemplate.getJmsTemplate().send("boxVersionUpdateTopic_PTP", new MessageCreator(){
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMsg = session.createTextMessage("{\"versionCode\":"+132+",\"url\":\"http://lbz-app.oss-cn-shenzhen.aliyuncs.com/app/attend_box/lbz_fly_v1.3.2_132_jiagu_sign.apk\"}");
				textMsg.setJMSDeliveryMode(DeliveryMode.PERSISTENT);
				textMsg.setStringProperty("clientId", clientId);
				return textMsg;
			}
		});
		return "ok";
	}
	
	
	@RequestMapping(value="boxUpdate/{clientId}/{version:.+}")
	public Object boxUpdate(@PathVariable("clientId") final String clientId,@PathVariable("version") final String version){
		boolean isUpdate = true;
		Map<String,Object> message = new HashMap<>();
		switch(version) {
			case "v1.2.3":
				message.put("versionCode", 123);
				message.put("url", "http://lbz-app.oss-cn-shenzhen.aliyuncs.com/app/attend_box/lbz_fly123_20180428.apk");
				break;
			case "v1.3.2":
				message.put("versionCode", 132);
				message.put("url", "http://lbz-app.oss-cn-shenzhen.aliyuncs.com/app/attend_box/lbz_fly_v1.3.2_132_jiagu_sign.apk");
				break;
			case "v1.3.5":
				message.put("versionCode", 135);
				message.put("url", "http://lbz-app.oss-cn-shenzhen.aliyuncs.com/app/attend_box/lbz_fly135_135_jiagu_sign.apk");
				break;
			case "v1.3.8":
				message.put("versionCode", 138);
				message.put("url", "http://lbz-app.oss-cn-shenzhen.aliyuncs.com/app/attend_box/lbz_fly0138_138_jiagu_sign.apk");
				break;
			case "v1.4.3":
				message.put("versionCode", 143);
				message.put("url", "http://lbz-app.oss-cn-shenzhen.aliyuncs.com/app/attend_box/lbz_fly0138_138_jiagu_sign.apk");
				break;
			case "v1.5.0":
				message.put("versionCode", 150);
				message.put("url", "http://lbz-app.oss-cn-shenzhen.aliyuncs.com/app/attend_box/lbz_fly150_150_jiagu_sign.apk");
				break;
			case "v1.6.1":
				message.put("versionCode", 160);
				message.put("url", "https://lbz-app.oss-cn-shenzhen.aliyuncs.com/app/attend_box/lbz_fly161_161_jiagu_sign.apk");
				break;
				
			case "v3.0.0":
				message.put("versionCode", 300);
				message.put("url", "https://lbz-app.oss-cn-shenzhen.aliyuncs.com/app/attend_box/3.0/lbz_300_0626_300_jiagu_sign.apk");
				break;
				
			case "v3.0.4":
				message.put("versionCode", 304);
				message.put("url", "https://lbz-app.oss-cn-shenzhen.aliyuncs.com/app/attend_box/lbz304-release-07161638.apk");
				break;	
			default:
				isUpdate = false;
		}
		if(isUpdate) {
			jmsMessagingTemplate.getJmsTemplate().send("boxVersionUpdateTopic_PTP", new MessageCreator(){
				@Override
				public Message createMessage(Session session) throws JMSException {
					TextMessage textMsg = session.createTextMessage(JSON.toJSONString(message));
					textMsg.setJMSDeliveryMode(DeliveryMode.PERSISTENT);
					textMsg.setStringProperty("clientId", clientId);
					return textMsg;
				}
			});
		}
		return "ok";
	}
	
	@RequestMapping(value="sendMsg/{topic}/{msg}")
	public Object sendMsg(@PathVariable final String topic,@PathVariable final String msg){
		jmsMessagingTemplate.getJmsTemplate().send(topic, new MessageCreator(){
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMsg = session.createTextMessage(msg);
				textMsg.setStringProperty("clientId", "26604ec974c24ee494dc7a2bdb8e6e7b");
				return textMsg;
			}
		});
		return "ok";
	}
	
	@PostMapping(value="removeMember/{clientId}")
	public Object removeMember(@PathVariable final String clientId,@RequestBody JSONObject message){
		jmsMessagingTemplate.getJmsTemplate().send("teamDeleteMemberTopic_PTP", new MessageCreator(){
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMsg = session.createTextMessage(message.toJSONString());
				textMsg.setStringProperty("clientId", clientId);
				return textMsg;
			}
		});
		return "ok";
	}
	
	
	@PostMapping(value="madeAttendCardno/{clientId}")
	public Object madeAttendCardnoSubscriber(@PathVariable final String clientId,@RequestBody JSONObject message){
		jmsMessagingTemplate.getJmsTemplate().send("madeAttendCardnoTopic_PTP", new MessageCreator(){
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMsg = session.createTextMessage(message.toJSONString());
				textMsg.setStringProperty("clientId", clientId);
				return textMsg;
			}
		});
		return "ok";
	}
	
	
	@PostMapping(value="recycleAttendCardno/{clientId}")
	public Object recycleAttendCardnoTopic(@PathVariable final String clientId,@RequestBody JSONObject message){
		jmsMessagingTemplate.getJmsTemplate().send("recycleAttendCardnoTopic_PTP", new MessageCreator(){
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMsg = session.createTextMessage(message.toJSONString());
				textMsg.setStringProperty("clientId", clientId);
				return textMsg;
			}
		});
		return "ok";
	}
	
}
