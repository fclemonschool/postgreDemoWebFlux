package io.fclemonschool.postgredemo_webflux.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fclemonschool.postgredemo_webflux.model.Coffee;
import io.fclemonschool.postgredemo_webflux.model.CoffeeDTO;
import io.fclemonschool.postgredemo_webflux.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/coffees")
public class CoffeeController {

    CoffeeService coffeeService;

    @Autowired
    public void setCoffeeService(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @PostMapping()
    public Mono<Coffee> addCoffee(@RequestBody CoffeeDTO coffeeDTO) {
        var objectMapper = new ObjectMapper();
        return coffeeService.addCoffee(objectMapper.convertValue(coffeeDTO, Coffee.class));
    }

    @GetMapping("/{coffeeKey}")
    public Mono<Coffee> getCoffee(@PathVariable long coffeeKey) {
        var coffee = new Coffee();
        coffee.setId(coffeeKey);
        return coffeeService.getCoffee(coffee);
    }

    @GetMapping()
    public Flux<Coffee> getAllCoffees() {
        return coffeeService.getAllCoffees();
    }
}
