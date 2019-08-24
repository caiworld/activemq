package com.caihao.activemqdemo.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 队列模式消费者2
 *
 * @author caihao
 * @date 2019/8/18 16:59
 */
public class QueueListener2 implements MessageListener {

  @Override
  public void onMessage(Message message) {
    // 判断message是否是TextMessage类型
    if (message instanceof TextMessage) {
      TextMessage textMessage = (TextMessage) message;
      try {
        System.out.println("队列模式消费者2：" + textMessage.getText());
      } catch (JMSException e) {
        e.printStackTrace();
      }
    }
  }
}
