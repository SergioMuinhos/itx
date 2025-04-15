package com.prueba.itx.infrastructure.adapter;

import com.prueba.itx.application.usescases.PriceOutputPort;
import com.prueba.itx.domain.model.Price;
import com.prueba.itx.infrastructure.adapter.in.controller.PriceMapper;
import com.prueba.itx.infrastructure.adapter.out.persistence.entity.PriceEntity;
import com.prueba.itx.infrastructure.adapter.out.persistence.repository.PriceRepositoryJpa;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
public class PricePersistenceAdapter implements PriceOutputPort {

    private final PriceRepositoryJpa priceRepository;

    private final PriceMapper priceMapper;

    @Override
    public Optional<Price> getPrice(Long productId, Long brandId, LocalDateTime applicationDate) {
        List<PriceEntity> priceFound = priceRepository.findPrice(applicationDate, productId, brandId);
        if (priceFound.isEmpty()) {
            return Optional.empty();
        }
        Price price = priceMapper.entityToDomain(priceFound.get(0));
        return Optional.of(price);

    }
}
