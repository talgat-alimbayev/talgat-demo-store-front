package talgat.demo.store.front.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import talgat.demo.store.front.model.Item;

import java.util.List;

@Service
public class ItemServices {

//    public Flux<Item> getAllItems(){
//        Flux<Item> items = WebClient.create("http://localhost:8080")
//                .get()
//                .uri(uriBuilder -> uriBuilder
//                        .path("/api/items")
//                        .queryParam("all").build())
//                .retrieve()
//                .bodyToFlux(Item.class);
//        return items;
//    }
//
//    public Mono<Item> getById(String id){
//        Mono<Item> item = WebClient.create()
//                .get()
//                .uri(uriBuilder -> uriBuilder
//                        .path("localhost:8080/api/items")
//                        .queryParam("id",id).build())
//                .retrieve()
//                .bodyToMono(Item.class);
//        return item;
//    }
    private RestTemplate rest;

    public ItemServices(RestTemplate rest) {
        this.rest = rest;
    }

    public Item getItemById(String id){
//        return rest.getForObject("http://localhost:8080/api/items?id={id}", Item.class, id);
        ResponseEntity<Item[]> response = rest.getForEntity("http://localhost:8080/api/items?ids={id}", Item[].class, id);
        Item[] items = response.getBody();
//        System.out.println(items[0]);
        return items[0];
//        Item[] items = response.getBody();
//
//        System.out.println(response.getBody());
//        return response.getBody().stream().;
////        return new Item();
    }

    public List<Item> getAllItems(){
        List<Item> response = rest.getForObject("http://localhost:8080/api/items?all", List.class);
        return response;
    }

    public Item createItem(Item item){
        return rest.postForObject("http://localhost:8080/api/items", item, Item.class);
    }
}
