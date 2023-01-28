package talgat.demo.store.front.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import talgat.demo.store.front.model.ItemStore;
import talgat.demo.store.front.services.ItemService;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {

    private ItemService itemService;

    public AdminController(ItemService itemService) {
        this.itemService = itemService;
    }

    @ModelAttribute(name = "item")
    public ItemStore addItemToModel(){
        return new ItemStore();
    }

    @GetMapping
    public String addItems(){
        return "admin";
    }

    @PostMapping
    public String processItem(@Valid ItemStore item, Errors errors, SessionStatus sessionStatus){
        if (errors.hasErrors()){
            return "admin";
        }
        itemService.createItem(item);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
