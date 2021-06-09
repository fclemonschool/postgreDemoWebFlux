package io.fclemonschool.postgredemo_webflux.service;

import io.fclemonschool.postgredemo_webflux.model.Coffee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CoffeeService extends AbstractService {

    Mono<Coffee> addCoffee(Coffee coffee);

    Mono<Coffee> getCoffee(Coffee coffee);

    Mono<Coffee> updateCoffee(Coffee coffee);

    Mono<Void> deleteCoffee(Coffee coffee);

    Flux<Coffee> getAllCoffees();
}
