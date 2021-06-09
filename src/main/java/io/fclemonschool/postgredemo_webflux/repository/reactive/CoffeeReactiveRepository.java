package io.fclemonschool.postgredemo_webflux.repository.reactive;

import io.fclemonschool.postgredemo_webflux.model.Coffee;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface CoffeeReactiveRepository extends R2dbcRepository<Coffee, Long> {
}
