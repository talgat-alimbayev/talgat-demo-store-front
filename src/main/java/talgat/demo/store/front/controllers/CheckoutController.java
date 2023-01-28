package talgat.demo.store.front.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import talgat.demo.store.front.model.Cart;
import talgat.demo.store.front.model.ItemOrder;
import talgat.demo.store.front.model.Order;
import talgat.demo.store.front.model.User;
import talgat.demo.store.front.services.CheckoutService;

import java.util.stream.Collectors;

@Controller
@SessionAttributes({"order", "cart"})
@RequestMapping("/checkout")
@Slf4j
public class CheckoutController {
    private CheckoutService checkoutService;
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @GetMapping
    public String orderForm(@ModelAttribute Order order,
                            @AuthenticationPrincipal User user){
        if (order.getDeliveryAddress() == null){
            order.setDeliveryAddress(user.getAddress());
        }
        if (order.getDeliveryName() == null){
            order.setDeliveryName(user.getFullName());
        }
        if (order.getEmail() == null){
            order.setEmail(user.getEmail());
        }
        return "checkout";
    }
    @PostMapping
    public String placeOrder(@Valid @ModelAttribute("order") Order order, Errors errors,
                             @ModelAttribute Cart cart,
                             SessionStatus sessionStatus
                             ){
        if (errors.hasErrors()){
            return "checkout";
        }
        order.setItems(cart.getItems().stream().map(itemStore -> new ItemOrder(itemStore)).collect(Collectors.toList()));
        order.setUserId(2L);
        checkoutService.saveOrder(order);
        sessionStatus.setComplete();
        return "success";
    }
}
