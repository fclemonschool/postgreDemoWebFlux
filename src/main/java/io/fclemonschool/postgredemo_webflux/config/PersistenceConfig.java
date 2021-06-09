package io.fclemonschool.postgredemo_webflux.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableR2dbcRepositories(basePackages = "io.fclemonschool.postgredemo_webflux.repository.reactive")
public class PersistenceConfig {
}
