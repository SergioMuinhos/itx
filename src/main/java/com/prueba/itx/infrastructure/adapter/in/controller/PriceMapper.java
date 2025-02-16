package com.prueba.itx.infrastructure.adapter.in.controller;

import com.prueba.itx.domain.model.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PriceMapper {
    PriceDto priceToPriceDto(Price price);

    @Mapping(target = "chainId", source = "brand.id")
    Price entityToDomain(PriceEntity entity);
}
