package com.prueba.itx.application.usescases;

import com.prueba.itx.domain.model.Price;

import java.time.LocalDateTime;

public interface GetPriceUseCase {

    Price getPrice(Long productId, Long brandId, LocalDateTime applicationDate);
}
