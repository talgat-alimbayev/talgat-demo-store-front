package talgat.demo.store.front.controllers;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import talgat.demo.store.front.model.Item;
import talgat.demo.store.front.services.ItemServices;

@Component
public class ItemByIdConverter implements Converter<String, Item> {

    private ItemServices itemServices;

    public ItemByIdConverter(ItemServices itemServices) {
        this.itemServices = itemServices;
    }

    @Override
    public Item convert(String id) {
        return itemServices.getItemById(id);
    }

}
