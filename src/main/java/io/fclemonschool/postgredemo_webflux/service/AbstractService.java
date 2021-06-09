package io.fclemonschool.postgredemo_webflux.service;

import io.fclemonschool.postgredemo_webflux.model.AbstractModel;
import io.fclemonschool.postgredemo_webflux.model.CommonResponse;
import reactor.core.publisher.Flux;

public interface AbstractService {

    default Flux<CommonResponse> post(Flux<AbstractModel> abstractModelFlux) {
        return abstractModelFlux.flatMap(abstractModel -> Flux.just(new CommonResponse(abstractModel, true)));
    }
}
