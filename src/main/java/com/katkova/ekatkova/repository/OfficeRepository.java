package com.katkova.ekatkova.repository;

import com.katkova.ekatkova.entity.OfficeEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends JpaRepository<OfficeEntity, Long>, JpaSpecificationExecutor<OfficeEntity> {
    boolean existsByNameAndPhone(String name, String phone);

    OfficeEntity findFirstById(Long id);

    static Specification<OfficeEntity> hasOrgId(Long orgId){
        return ((office, cq, cb) -> cb.equal(office.get("orgId"), orgId));
    }
    static Specification<OfficeEntity> hasNameLike(String name){
        return (office, cq, cb) -> cb.like(office.get("name"), "%" + name + "%");
    }

    static Specification<OfficeEntity> hasPhone(String phone){
        return ((office, cq, cb) -> cb.equal(office.get("phone"), phone));
    }

    static Specification<OfficeEntity> hasIsActive(Boolean isActive){
        return ((office, cq, cb) -> cb.equal(office.get("isActive"), isActive));
    }
}
