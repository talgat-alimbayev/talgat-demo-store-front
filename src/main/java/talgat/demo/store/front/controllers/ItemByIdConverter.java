package talgat.demo.store.front.controllers;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import talgat.demo.store.front.model.ItemStore;
import talgat.demo.store.front.services.ItemService;

@Component
public class ItemByIdConverter implements Converter<String, ItemStore> {

    private ItemService itemServices;

    public ItemByIdConverter(ItemService itemServices) {
        this.itemServices = itemServices;
    }

    @Override
    public ItemStore convert(String id) {
        return itemServices.getItemById(id);
    }

}
