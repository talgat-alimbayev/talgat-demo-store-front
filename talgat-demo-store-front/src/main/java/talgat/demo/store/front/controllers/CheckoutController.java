package talgat.demo.store.front.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import talgat.demo.store.front.model.Cart;
import talgat.demo.store.front.model.Order;
import talgat.demo.store.front.services.CheckoutServices;

@Controller
@SessionAttributes({"order", "cart"})
@RequestMapping("/checkout")
@Slf4j
public class CheckoutController {
    private CheckoutServices checkoutServices;

    public CheckoutController(CheckoutServices checkoutServices) {
        this.checkoutServices = checkoutServices;
    }

    @GetMapping
    public String orderForm(){
        return "checkout";
    }

    @PostMapping
    public String placeOrder(@Valid @ModelAttribute("order") Order order, Errors errors,
                             @ModelAttribute Cart cart,
                             SessionStatus sessionStatus
                             ){
        log.info("printing order from CheckoutController");
        if (errors.hasErrors()){
            return "checkout";
        }
        order.setItemIds(cart.getItemIds());
        order.setOrderTotal(cart.getTotal());
        checkoutServices.saveOrder(order).subscribe();
        log.info("printing order from CheckoutController");
        log.info(order.toString());
        sessionStatus.setComplete();
        return "success";
    }
}
