package io.fclemonschool.postgredemo_webflux.model;

import lombok.Data;

@Data
public class CoffeeDTO {
    String name;

    String aroma;

    String price;
}
