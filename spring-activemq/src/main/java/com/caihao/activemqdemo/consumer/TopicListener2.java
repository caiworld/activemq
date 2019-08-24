package com.caihao.activemqdemo.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * TODO
 *
 * @author caihao
 * @date 2019/8/24 17:24
 */
public class TopicListener2 implements MessageListener {

  @Override
  public void onMessage(Message message) {
    if (message instanceof TextMessage) {
      TextMessage textMessage = (TextMessage) message;
      try {
        System.out.println("topic模式消费者2：" + textMessage.getText());
      } catch (JMSException e) {
        e.printStackTrace();
      }
    }
  }
}
