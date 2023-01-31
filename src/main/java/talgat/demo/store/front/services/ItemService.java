package talgat.demo.store.front.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import talgat.demo.store.front.model.ItemStore;

import java.util.List;

@Service
public class ItemService {
    private RestTemplate rest;

    public ItemService(RestTemplate rest) {
        this.rest = rest;
    }

    public ItemStore getItemById(String id){
        ResponseEntity<ItemStore> response = rest.getForEntity("/store/items/find-by-id?id={id}", ItemStore.class, id);
        ItemStore item = response.getBody();
        return item;
    }

    public List<ItemStore> getAllItems(){
        List<ItemStore> response = rest.getForObject("/store/items/find?all", List.class);
        return response;
    }

    public ItemStore createItem(ItemStore item){
        return rest.postForObject("/store/items/create", item, ItemStore.class);
    }
}
