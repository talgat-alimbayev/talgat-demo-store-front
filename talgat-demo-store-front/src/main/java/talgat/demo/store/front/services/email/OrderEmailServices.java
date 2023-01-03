package talgat.demo.store.front.services.email;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Service;
import talgat.demo.store.front.model.Order;
@Service
public class OrderEmailServices {
    private RabbitTemplate rabbit;


    public OrderEmailServices(RabbitTemplate rabbit) {
        this.rabbit = rabbit;
    }

    public void sendOrderEmail(Order order){
        MessageConverter converter = rabbit.getMessageConverter();
        MessageProperties properties = new MessageProperties();
        Message message = converter.toMessage(order, properties);
        rabbit.send("talgat-demo-store", "order-email", message);
    }
}
