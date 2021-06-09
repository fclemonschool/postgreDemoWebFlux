package io.fclemonschool.postgredemo_webflux.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse {
    private AbstractModel data;
    private boolean result;
}
