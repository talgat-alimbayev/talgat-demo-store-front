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

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"order", "cart"})
@Slf4j
@RequestMapping(path = "/items")
public class CartController {

    private ItemServices itemServices;

    public CartController(ItemServices itemServices) {
        this.itemServices = itemServices;
    }

    @ModelAttribute
    public void addItemsToModel(Model model){
        List<Item> items = new ArrayList<Item>();
        itemServices.getAllItems().doOnNext(item -> items.add(item)).blockLast(Duration.ofMillis(100));
        log.info("Printing items from CartController");
//        itemServices.getAll().doOnNext(item -> System.out.println(item)).subscribe();
        log.info(items.toString());
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
        return "items";
    }

    @PostMapping
    public String processAddedItems(@ModelAttribute Cart cart){
//        if (errors.hasErrors()){
//            return "/items";
//        }
        log.info(cart.getItemList().toString());
        return "redirect:/checkout";
    }
}
