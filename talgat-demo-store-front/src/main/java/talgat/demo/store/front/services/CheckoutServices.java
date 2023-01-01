package talgat.demo.store.front.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import talgat.demo.store.front.model.Order;

@Service
public class CheckoutServices {

//    public Mono<Order> saveOrder(Order order){
//        Mono<Order> result = WebClient.create("http://localhost:8080")
//                .post()
//                .uri("/api/orders")
//                .body(Mono.just(order), Order.class)
//                .retrieve()
//                .bodyToMono(Order.class);
//        return result;
//    }
    private RestTemplate rest;

    public CheckoutServices(RestTemplate rest) {
        this.rest = rest;
    }

    public Order saveOrder(Order order){
        return rest.postForObject("http://localhost:8080/api/orders", order, Order.class);
    }
}
