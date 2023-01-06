package talgat.demo.store.front.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import talgat.demo.store.front.model.Order;

@Service
public class CheckoutServices {
    private RestTemplate rest;

    public CheckoutServices(RestTemplate rest) {
        this.rest = rest;
    }

    public Order saveOrder(Order order){
        return rest.postForObject("http://backend:8080/api/orders", order, Order.class);
    }
}
