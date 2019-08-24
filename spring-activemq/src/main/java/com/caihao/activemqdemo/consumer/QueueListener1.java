package com.caihao.activemqdemo.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 队列模式-消息消费者1
 *
 * @author caihao
 * @date 2019/8/18 16:54
 */
public class QueueListener1 implements MessageListener{

  @Override
  public void onMessage(Message message) {
    // 由于我这里只负责接收TextMessage类型，因此做一个类型判断
    if (message instanceof TextMessage){
      TextMessage textMessage = (TextMessage) message;
      try {
        System.out.println("队列模式消费者1："+textMessage.getText());
      } catch (JMSException e) {
        e.printStackTrace();
      }
    }
  }
}
