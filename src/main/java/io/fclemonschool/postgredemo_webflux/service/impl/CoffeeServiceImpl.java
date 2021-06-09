package io.fclemonschool.postgredemo_webflux.service.impl;

import io.fclemonschool.postgredemo_webflux.model.Coffee;
import io.fclemonschool.postgredemo_webflux.repository.reactive.CoffeeReactiveRepository;
import io.fclemonschool.postgredemo_webflux.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CoffeeServiceImpl implements CoffeeService {

    CoffeeReactiveRepository coffeeReactiveRepository;

    @Autowired
    public void setCoffeeReactiveRepository(CoffeeReactiveRepository coffeeReactiveRepository) {
        this.coffeeReactiveRepository = coffeeReactiveRepository;
    }

    @Override
    public Mono<Coffee> addCoffee(Coffee coffee) {
        return coffeeReactiveRepository.save(coffee);
    }

    @Override
    public Mono<Coffee> getCoffee(Coffee coffee) {
        return coffeeReactiveRepository.findById(coffee.getId());
    }

    @Override
    public Mono<Coffee> updateCoffee(Coffee coffee) {
        return getCoffee(coffee).map(c -> coffee)
                .flatMap(coffeeReactiveRepository::save)
                .switchIfEmpty(Mono.error(new Exception("Not Found.")));
    }

    @Override
    public Mono<Void> deleteCoffee(Coffee coffee) {
        return getCoffee(coffee)
                .switchIfEmpty(Mono.error(new Exception("Not Found.")))
                .flatMap(coffeeReactiveRepository::delete);
    }

    @Override
    public Flux<Coffee> getAllCoffees() {
        return coffeeReactiveRepository.findAll();
    }
}
