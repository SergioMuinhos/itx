package com.prueba.itx.infrastructure.adapter.in.controller;

import com.prueba.itx.application.usescases.GetPriceUseCase;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.openapitools.api.PricesApi;
import org.openapitools.model.PriceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Api(tags = "Price API")
public class PriceController implements PricesApi {

    private final GetPriceUseCase getPriceUseCase;
    private final PriceMapper mapper = Mappers.getMapper(PriceMapper.class);

    @Override
    public ResponseEntity<PriceDto> pricesGet(String applicationDate, Long productId, Long brandId) {
        var price = getPriceUseCase.getPrice(productId, brandId, LocalDateTime.parse(applicationDate));
            return ResponseEntity.ok(mapper.priceToPriceDto(price));
    }
}
