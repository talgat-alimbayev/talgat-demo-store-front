package talgat.demo.store.front.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import talgat.demo.store.front.model.Order;
import talgat.demo.store.front.services.CheckoutServices;

@Controller
@SessionAttributes("order")
public class CheckoutController {
    private CheckoutServices checkoutServices;

    public CheckoutController(CheckoutServices checkoutServices) {
        this.checkoutServices = checkoutServices;
    }

    @PostMapping(path = "/checkout")
    public String placeOrder(@ModelAttribute @Valid Order order,
                             Errors errors,
                             SessionStatus sessionStatus){
        if (errors.hasErrors()){
            return
        }
    }
}
