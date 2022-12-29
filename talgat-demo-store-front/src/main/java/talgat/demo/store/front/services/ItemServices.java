package talgat.demo.store.front.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import talgat.demo.store.front.model.Item;

@Service
public class ItemServices {

    public Flux<Item> getAllItems(){
        Flux<Item> items = WebClient.create("http://localhost:8080")
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/items")
                        .queryParam("all").build())
                .retrieve()
                .bodyToFlux(Item.class);
        return items;
    }

    public Mono<Item> getById(String id){
        Mono<Item> item = WebClient.create()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("localhost:8080/api/items")
                        .queryParam("id",id).build())
                .retrieve()
                .bodyToMono(Item.class);
        return item;
    }
}
