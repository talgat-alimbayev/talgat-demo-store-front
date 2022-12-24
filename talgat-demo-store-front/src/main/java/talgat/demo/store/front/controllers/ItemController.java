package talgat.demo.store.front.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import talgat.demo.store.front.model.Item;
import talgat.demo.store.front.model.Order;
import talgat.demo.store.front.services.ItemServices;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("order")
@Slf4j
public class ItemController {

    private ItemServices itemServices;

    public ItemController(ItemServices itemServices) {
        this.itemServices = itemServices;
    }

    @ModelAttribute
    public void addItemsToModel(Model model){
        List<Item> items = new ArrayList<Item>();
        itemServices.getAllItems().doOnNext(item -> items.add(item)).blockLast(Duration.ofMillis(100));
        log.info("Printing items from ItemController");
//        itemServices.getAll().doOnNext(item -> System.out.println(item)).subscribe();
        log.info(items.toString());
        model.addAttribute("items", items);
    }

    @ModelAttribute(name = "order")
    public Order addOrderToModel(Model model){
        return new Order();
    }

    @GetMapping(path = "/items")
    public String showItems(){
        return "items";
    }

    @PostMapping(path = "/items")
    public String processAddedItems(@ModelAttribute @Valid Order order, Errors errors){
        if (errors.hasErrors()){
            return "/items";
        }
        return "redirect:/checkout";
    }
}
