package com.didispace.consumer;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	private final static Logger logger = LoggerFactory.getLogger(Consumer.class);
	
	@JmsListener(destination="boxVersionUpdateTopic_PTP")
	public void receiveQueue(String text){
		logger.info("consumer接收到的报文:"+text);	
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
		logger.info("consumer1接收到的报文:"+text);	
	 return "return message:"+text+">>>Has been received reply";
	}
	
	@JmsListener(destination="mqMessage")
	public void cousumerTopic(String text){
		logger.info("consumer2接收到的报文:"+text);
	}
	/**
	 * topic
	 * @author  xyl
	 */
	@JmsListener(destination="sample.topic")
	public void consumerTopic2(String text){
		logger.info("topic consumer2>>>"+text);
	}
	/**
	 * topic
	 * @author  xyl
	 */
	@JmsListener(destination="sample.topic")
	public void consumerTopic3(String text){
		logger.info("topic consumer3>>>"+text);
	}
	
	/**
	 * queue
	 * @author  xyl
	 */
	@JmsListener(destination="sample.queue")
	public void consumerQueue2(String text){
		logger.info("queue consumer2>>>"+text);
	}
	/**
	 * queue
	 * @author  xyl
	 */
	@JmsListener(destination="sample.queue")
	public void consumerQueue3(String text){
		logger.info("queue consumer3>>>"+text);
	}
	
}
