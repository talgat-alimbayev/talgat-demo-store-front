package talgat.demo.store.front.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import talgat.demo.store.front.model.Item;
import talgat.demo.store.front.model.Order;

@Service
public class CheckoutServices {

    public Mono<Order> postOrder(Order order){
        Mono<Order> result = WebClient.create()
                .post()
                .uri("/localhost:8080/api/orders")
                .bodyValue(order)
                .retrieve()
                .bodyToMono(Order.class);
        return result;
    }
}
