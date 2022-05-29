package com.katkova.ekatkova.repository;

import com.katkova.ekatkova.entity.DocEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocRepository extends JpaRepository<DocEntity, Long> {
}
