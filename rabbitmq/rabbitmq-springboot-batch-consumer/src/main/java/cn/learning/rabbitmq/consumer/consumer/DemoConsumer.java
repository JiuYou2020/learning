package cn.learning.rabbitmq.consumer.consumer;

import cn.learning.rabbitmq.consumer.message.DemoMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

// Demo05Consumer.java

@Component
@Slf4j
@RabbitListener(queues = DemoMessage.QUEUE,
        containerFactory = "consumerBatchContainerFactory")
public class DemoConsumer {
    @RabbitHandler
    public void onMessage(List<DemoMessage> messages) {
        log.info("[onMessage][线程编号:{} 消息数量：{}]", Thread.currentThread().getId(), messages.size());
    }

}