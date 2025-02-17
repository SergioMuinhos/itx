package com.prueba.itx.infrastructure.adapter.config;

import com.prueba.itx.domain.service.PriceService;
import com.prueba.itx.infrastructure.adapter.in.controller.PriceMapper;
import com.prueba.itx.infrastructure.adapter.out.persistence.PricePersistenceAdapter;
import com.prueba.itx.infrastructure.adapter.out.persistence.repository.PriceRepositoryJpa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.mappers.ModelMapper;

/**
 * Configuracion BEANS
 */
@Configuration
public class BeanConfiguration {


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public PricePersistenceAdapter productPersistenceAdapter(PriceRepositoryJpa priceRepository, PriceMapper priceMapper) {
        return new PricePersistenceAdapter(priceRepository, priceMapper);
    }

    @Bean
    public PriceService productService(PricePersistenceAdapter productPersistenceAdapter) {
        return new PriceService(productPersistenceAdapter);
    }

}
