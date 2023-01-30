package talgat.demo.store.front.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import talgat.demo.store.front.model.Cart;
import talgat.demo.store.front.model.ItemOrder;
import talgat.demo.store.front.model.Order;
import talgat.demo.store.front.model.User;

import java.util.stream.Collectors;

@Service
public class CheckoutService {
    private RestTemplate rest;

    public CheckoutService(RestTemplate rest) {
        this.rest = rest;
    }

    public Order saveOrder(Order order, Cart cart, User user){
        order.setItems(cart.getItems().stream().map(itemStore -> new ItemOrder(itemStore)).collect(Collectors.toList()));
        order.setUserId(user.getId());

        return rest.postForObject("/orders/save", order, Order.class);
    }
}
