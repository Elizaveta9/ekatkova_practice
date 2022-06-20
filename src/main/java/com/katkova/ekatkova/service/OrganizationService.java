package com.katkova.ekatkova.service;

import com.katkova.ekatkova.dto.*;
import com.katkova.ekatkova.entity.OrganizationEntity;
import com.katkova.ekatkova.mapper.OrganizationMapper;
import com.katkova.ekatkova.repository.OrganizationRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private DtoConvertor dtoConvertor;

    private OrganizationMapper mapper = Mappers.getMapper(OrganizationMapper.class);

    public ResponseResult save(RequestOrganizationSave organizationDto) {
        OrganizationEntity organizationEntity = dtoConvertor.toEntity(organizationDto, OrganizationEntity.class);
        organizationRepository.save(organizationEntity);
        return new ResponseResult(ResultTypeEnum.SUCCESS);
    }

    public boolean hasInn(String inn) {
        return organizationRepository.existsByInn(inn);
    }

    public List<ResponseOrganizationFilter> findAllUsingFilter(String name, String inn, String kpp) {
        String nameUpperCased = name.toUpperCase();
        List<OrganizationEntity> organizations = null;
        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + nameUpperCased + "%"));
                if (null != inn) {
                    predicates.add(criteriaBuilder.equal(root.get("inn"), inn));
                }
                if (null != kpp) {
                    predicates.add(criteriaBuilder.equal(root.get("kpp"), kpp));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        organizations = organizationRepository.findAll(specification);
        return dtoConvertor.toDtoList(organizations, ResponseOrganizationFilter.class);
//        List<OrganizationEntity> organizationEntities = organizationRepository.findAll(
//                OrganizationRepository.hasNameLike(name)
//                        .or(OrganizationRepository.hasInn(inn))
//                        .or(OrganizationRepository.hasKpp(kpp)));
//        return dtoConvertor.toDtoList(organizationEntities, ResponseOrganizationFilter.class);
    }

    public ResponseOrganizationId findById(Long id) {
        OrganizationEntity organizationEntity = organizationRepository.findFirstById(id);
        if (organizationEntity == null) {
            return null;
        }
        return dtoConvertor.toDto(organizationEntity, ResponseOrganizationId.class);
    }

    public Response update(RequestOrganizationUpdate organizationUpdatedDto) {
        if (organizationRepository.existsById(organizationUpdatedDto.getId())) {
            OrganizationEntity organizationEntity = organizationRepository.findFirstById(organizationUpdatedDto.getId());
            mapper.updateOrganizationFromDto(organizationUpdatedDto, organizationEntity);
            organizationRepository.save(organizationEntity);
            return new ResponseResult(ResultTypeEnum.SUCCESS);
        } else {
            return new ResponseResult(ResultTypeEnum.NO_SUCH_ORGANIZATION);
        }
    }
}
