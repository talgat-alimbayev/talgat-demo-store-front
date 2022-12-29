package talgat.demo.store.front.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import talgat.demo.store.front.model.Item;
import talgat.demo.store.front.model.Order;

@Service
public class CheckoutServices {

    public Mono<Order> saveOrder(Order order){
        Mono<Order> result = WebClient.create("http://localhost:8080")
                .post()
                .uri("/api/orders")
                .body(Mono.just(order), Order.class)
                .retrieve()
                .bodyToMono(Order.class);
        return result;
    }
}
