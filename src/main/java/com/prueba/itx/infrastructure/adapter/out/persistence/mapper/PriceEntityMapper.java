package com.prueba.itx.infrastructure.adapter.out.persistence.mapper;

import com.prueba.itx.domain.model.Price;
import com.prueba.itx.infrastructure.adapter.out.persistence.entity.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.model.PriceDto;

@Mapper
public interface PriceEntityMapper {
    @Mapping(target = "chainId", source = "brand.id")
    Price priceEntityToPrice(PriceEntity priceEntity);

    PriceDto toDto(PriceEntity entity);

    PriceDto toDtoFromPrice(Price price);

    PriceEntity toEntity(PriceDto dto);
}
