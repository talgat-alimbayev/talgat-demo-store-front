package talgat.demo.store.front.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import talgat.demo.store.front.model.Cart;
import talgat.demo.store.front.model.Item;
import talgat.demo.store.front.model.Order;
import talgat.demo.store.front.services.ItemServices;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"order", "cart"})
@Slf4j
@RequestMapping(path = "/store")
public class StoreController {

    private ItemServices itemServices;

    public StoreController(ItemServices itemServices) {
        this.itemServices = itemServices;
    }

    @ModelAttribute
    public void addItemsToModel(Model model){
        List<Item> items = new ArrayList<Item>();
        items = itemServices.getAllItems();
        model.addAttribute("items", items);
    }

    @ModelAttribute(name = "order")
    public Order addOrderToModel(){
        return new Order();
    }

    @ModelAttribute(name = "cart")
    public Cart addCartToModel(){
        return new Cart();
    }

    @GetMapping
    public String showItems(){
        return "store";
    }

    @PostMapping
    public String processAddedItems(@ModelAttribute @Valid Cart cart, Errors errors){
        if (errors.hasErrors()){
            return "store";
        }
        cart.calculateTotal();
        return "redirect:/checkout";
    }
}
