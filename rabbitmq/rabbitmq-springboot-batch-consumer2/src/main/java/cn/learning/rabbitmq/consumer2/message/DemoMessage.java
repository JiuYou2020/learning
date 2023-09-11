package cn.learning.rabbitmq.consumer2.message;

import java.io.Serializable;

public class DemoMessage implements Serializable {

    public static final String QUEUE = "QUEUE_DEMO";

    public static final String EXCHANGE = "EXCHANGE_DEMO";

    public static final String ROUTING_KEY = "ROUTING_KEY";

    /**
     * 编号
     */
    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DemoMessage{" +
                "id=" + id +
                '}';
    }

}
