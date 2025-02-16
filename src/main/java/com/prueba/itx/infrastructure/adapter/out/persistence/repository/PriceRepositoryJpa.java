package com.prueba.itx.infrastructure.adapter.out.persistence.repository;

import com.prueba.itx.infrastructure.adapter.out.persistence.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.retry.annotation.Retryable;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public interface PriceRepositoryJpa extends JpaRepository<PriceEntity, Long> {
    @Query("SELECT p FROM PriceEntity p WHERE p.productId = :productId AND  p.brand.id = :chainId  " +
            "AND ( :applicationDate BETWEEN p.startDate AND p.endDate )" +
            "ORDER BY p.priority DESC LIMIT 1")
    @Transactional(readOnly = true)
    @Retryable
    PriceEntity findPrice(@Param("applicationDate") LocalDateTime applicationDate,
                          @Param("productId") Long productId,
                          @Param("chainId") Long chainId);
}
