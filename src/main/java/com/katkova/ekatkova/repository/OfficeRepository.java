package com.katkova.ekatkova.repository;

import com.katkova.ekatkova.entity.OfficeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends JpaRepository<OfficeEntity, Long> {
    boolean existsByNameAndPhone(String name, String phone);
}
