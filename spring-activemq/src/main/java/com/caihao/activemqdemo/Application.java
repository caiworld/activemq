package com.caihao.activemqdemo;

import com.caihao.activemqdemo.producer.Producer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO
 *
 * @author caihao
 * @date 2019/8/18 18:07
 */
public class Application {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-activemq.xml");
    // 获取生产者实例
    Producer producer = (Producer) ac.getBean("producer");
    for (int i = 0; i < 100; i++) {
      // 发送队列消息
      // producer.sendQueueMessage("hello" + i);
      // 发送topic模式消息
      producer.sendTopicMessage("hello" + i);
    }
    // ac.close();
  }

}
