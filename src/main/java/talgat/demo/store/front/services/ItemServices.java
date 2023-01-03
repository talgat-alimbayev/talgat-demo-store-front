package talgat.demo.store.front.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import talgat.demo.store.front.model.Item;

import java.util.List;

@Service
public class ItemServices {
    private RestTemplate rest;

    public ItemServices(RestTemplate rest) {
        this.rest = rest;
    }

    public Item getItemById(String id){
        ResponseEntity<Item[]> response = rest.getForEntity("http://localhost:8080/api/items?ids={id}", Item[].class, id);
        Item[] items = response.getBody();
        return items[0]; //
    }

    public List<Item> getAllItems(){
        List<Item> response = rest.getForObject("http://localhost:8080/api/items?all", List.class);
        return response;
    }

    public Item createItem(Item item){
        return rest.postForObject("http://localhost:8080/api/items", item, Item.class);
    }
}
