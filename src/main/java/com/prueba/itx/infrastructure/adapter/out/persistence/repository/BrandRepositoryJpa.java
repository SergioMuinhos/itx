package com.prueba.itx.infrastructure.adapter.out.persistence.repository;

import com.prueba.itx.infrastructure.adapter.out.persistence.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepositoryJpa extends JpaRepository<BrandEntity, Long> {
}
