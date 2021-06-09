package io.fclemonschool.postgredemo_webflux.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

@Data
@Validated
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AbstractModel {

    @Id
    private long id;
    private LocalDateTime createDateTime = LocalDateTime.now();
}
