package talgat.demo.store.front.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import talgat.demo.store.front.model.Item;

@Service
public class ItemServices {

    public Flux<Item> getAll(){
        Flux<Item> ingredients = WebClient.create()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("localhost:8080/api/items")
                .queryParam("all").build())
                .retrieve()
                .bodyToFlux(Item.class);
        return ingredients;
    }
}
