package talgat.demo.store.front.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import talgat.demo.store.front.model.Item;
import talgat.demo.store.front.services.ItemServices;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {

    private ItemServices itemServices;

    public AdminController(ItemServices itemServices) {
        this.itemServices = itemServices;
    }

    @ModelAttribute(name = "item")
    public Item addItemToModel(){
        return new Item();
    }

    @GetMapping
    public String addItems(){
        return "admin";
    }

    @PostMapping
    public String processItem(@Valid Item item, Errors errors, SessionStatus sessionStatus){
        if (errors.hasErrors()){
            return "admin";
        }
        itemServices.createItem(item);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
