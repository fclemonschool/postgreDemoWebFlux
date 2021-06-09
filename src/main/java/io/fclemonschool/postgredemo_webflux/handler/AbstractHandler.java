package io.fclemonschool.postgredemo_webflux.handler;

import io.fclemonschool.postgredemo_webflux.model.AbstractModel;
import io.fclemonschool.postgredemo_webflux.model.CommonResponse;
import io.fclemonschool.postgredemo_webflux.service.AbstractService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Component
public class AbstractHandler {
    private final Validator validator;
    private final AbstractService abstractService;

    public Mono<ServerResponse> post (ServerRequest serverRequest) {
        Flux<CommonResponse> result  = abstractService.post(
            serverRequest.bodyToFlux(AbstractModel.class)
                .filter(abstractModel -> {
                    Set<ConstraintViolation<AbstractModel>> validationResult = validator.validate(abstractModel);
                    return validationResult.isEmpty();
                })
        );
        return ServerResponse.ok().body(result, CommonResponse.class);
    }

}
