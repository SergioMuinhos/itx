package com.prueba.itx.domain.service;

import com.prueba.itx.application.usescases.GetPriceUseCase;
import com.prueba.itx.application.usescases.PriceOutputPort;
import com.prueba.itx.domain.exception.NoPriceFoundException;
import com.prueba.itx.domain.model.Price;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class PriceService implements GetPriceUseCase {

    private final PriceOutputPort priceOutputPort;

    @Override
    public Price getPrice(Long productId, Long brandId, LocalDateTime applicationDate) {
        return priceOutputPort.getPrice(productId, brandId, applicationDate)
                .orElseThrow(() -> new NoPriceFoundException("No se ha encontrado el Precio indicado con los parametros: " +
                        "\n ProductID: " + productId + " BrandId: " + brandId + " Date: " + applicationDate));
    }
}
