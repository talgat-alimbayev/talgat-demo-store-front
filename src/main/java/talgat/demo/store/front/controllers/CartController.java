package talgat.demo.store.front.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import talgat.demo.store.front.model.Cart;

@Controller
@SessionAttributes({"order", "cart"})
@RequestMapping(path = "/cart")
public class CartController {

    @GetMapping
    public String cart(){
        return "cart";
    }

    @PostMapping
    public String updateCart(@ModelAttribute Cart cart){
        cart.calculateTotal();
        if (cart.getItems().isEmpty()){
            return "redirect:/store";
        }
        return "redirect:/checkout";
    }
}
