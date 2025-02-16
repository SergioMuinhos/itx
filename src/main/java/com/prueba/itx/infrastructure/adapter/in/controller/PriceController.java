package com.prueba.itx.infrastructure.adapter.in.controller;


import com.prueba.itx.application.usecases.GetPriceUseCase;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Api(tags = "Price API")
public class PriceController implements PricesApi{

    private final GetPriceUseCase getPriceUseCase;

    @Override
    public ResponseEntity<PriceDto> pricesGet(String applicationDate, Long productId, Long brandId) {
        PriceMapper mapper = Mappers.getMapper(PriceMapper.class);
        var price = getPriceUseCase.getPrice(productId, brandId, LocalDateTime.parse(applicationDate));
        if (price != null) {
            return ResponseEntity.ok(mapper.priceToPriceDto(price));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
