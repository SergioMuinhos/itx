package com.prueba.itx.application.usescases;

import com.prueba.itx.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceOutputPort {

    Optional<Price> getPrice(Long productId, Long brandId, LocalDateTime applicationDate);
}
