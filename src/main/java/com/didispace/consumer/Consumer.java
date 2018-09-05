package com.didispace.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	@JmsListener(destination="boxVersionUpdateTopic_PTP")
	public void receiveQueue(String text){
	System.out.println("consumer接收到的报文:"+text);	
	}
	
	/**
	 * @SendTo("out.queue")：表示的意思就是把接收到的消息发送到out.queue队列，然后生产者去监听
	 * 这个队列，取出消息
	 * 
	 * @author  xyl
	 */
	@JmsListener(destination="mqMessage")
	@SendTo("out.queue")
	public String receiveQueueToQueue(String text){
	 System.err.println("consumer1接收到的报文:"+text);	
	 return "return message:"+text+">>>Has been received reply";
	}
	
	@JmsListener(destination="mqMessage")
	public void cousumerTopic(String text){
		System.out.println("consumer2接收到的报文:"+text);
	}
	
	@JmsListener(destination="sample.topic")
	public void consumerTopic2(String text){
		System.out.println("topic consumer2"+text);
	}
	@JmsListener(destination="sample.topic")
	public void consumerTopic3(String text){
		System.err.println("topic consumer3"+text);
	}
}
