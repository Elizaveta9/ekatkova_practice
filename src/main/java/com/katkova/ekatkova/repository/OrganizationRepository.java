package com.katkova.ekatkova.repository;

import com.katkova.ekatkova.entity.OrganizationEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<OrganizationEntity, Long>, JpaSpecificationExecutor<OrganizationEntity> {
    OrganizationEntity findByInn(String inn);

    static Specification<OrganizationEntity> hasNameLike(String name) {
        return (organization, cq, cb) -> cb.like(organization.get("name"), "%" + name + "%");
    }

    static Specification<OrganizationEntity> hasInn(String inn) {
        return (organization, cq, cb) -> cb.equal(organization.get("inn"), inn);
    }

    static Specification<OrganizationEntity> hasKpp(String kpp) {
        return (organization, cq, cb) -> cb.equal(organization.get("kpp"), kpp);
    }
}
