package com.didispace.producer;

import java.util.Map;

import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

@Service("producer")
public class Producer {

	@Autowired
	private JmsMessagingTemplate jmsTemplate;
	@Autowired
	private Queue queue;
	@Autowired
	private Topic topic;
	//发送消息,destination是发送的队列,message是待发送的消息
	public void sendMessage(Destination destination,Map<String,Object> message ){
//		jmsTemplate.convertAndSend(destination, message);
		jmsTemplate.getJmsTemplate().send("boxVersionUpdateTopic_PTP", new MessageCreator(){
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMsg = session.createTextMessage(JSON.toJSONString(message));
				textMsg.setJMSDeliveryMode(DeliveryMode.PERSISTENT);
				textMsg.setStringProperty("clientId", "CG1806JBW0A0010");
				return textMsg;
			}
		});
	}
	
	public void sendMessageTest(Destination destination,String message){
		jmsTemplate.convertAndSend(destination, message);
	}
	
	
	public void sendMessage(){
		jmsTemplate.convertAndSend(this.queue, "hi activeMq queue");
		jmsTemplate.convertAndSend(this.topic, "hi activeMq topic");
	}
}
