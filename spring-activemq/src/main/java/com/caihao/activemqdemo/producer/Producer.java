package com.caihao.activemqdemo.producer;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 * 消息生产者
 *
 * @author caihao
 * @date 2019/8/18 16:52
 */
@Component
public class Producer {

  @Autowired
  private JmsTemplate jmsTemplate;
  @Resource(name = "queueDestination")
  private Destination queueDestination;

  /**
   * 发送队列消息
   *
   * @return void
   * @author 蔡浩
   * @date 2019/8/18 17:46
   * @since 1.0.0
   */
  public void sendQueueMessage(String message) {
    // 发送消息
    jmsTemplate.send(queueDestination, new MessageCreator() {
      @Override
      public Message createMessage(Session session) throws JMSException {
        // 返回创建的消息
        return session.createTextMessage(message);
      }
    });
  }

  @Resource(name = "topicDestination")
  private Destination topicDestination;

  /**
   * 发送topic模式消息
   *
   * @param message 消息
   * @author 蔡浩
   * @date 2019/8/24 17:13
   * @since 1.0.0
   */
  public void sendTopicMessage(String message) {
    // 发送消息
    jmsTemplate.send(topicDestination, (session) -> session.createTextMessage(message));
  }

}
