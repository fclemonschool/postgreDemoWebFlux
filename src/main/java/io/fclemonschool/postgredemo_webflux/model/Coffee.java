package io.fclemonschool.postgredemo_webflux.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Coffee extends AbstractModel {

    String name;

    String aroma;

    String price;
}
