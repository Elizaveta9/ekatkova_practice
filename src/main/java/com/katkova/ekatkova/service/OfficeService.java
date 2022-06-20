package com.katkova.ekatkova.service;

import com.katkova.ekatkova.dto.*;
import com.katkova.ekatkova.entity.OfficeEntity;
import com.katkova.ekatkova.mapper.OfficeMapper;
import com.katkova.ekatkova.repository.OfficeRepository;
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
public class OfficeService {
    @Autowired
    private OfficeRepository officeRepository;

    @Autowired
    private DtoConvertor dtoConvertor;

    private OfficeMapper mapper = Mappers.getMapper(OfficeMapper.class);

    public Response save(RequestOfficeSave officeDto) {
        OfficeEntity officeEntity = dtoConvertor.toEntity(officeDto, OfficeEntity.class);
        if (!officeRepository.existsByNameAndPhone(officeEntity.getName(), officeEntity.getPhone())) {
            officeRepository.save(officeEntity);
        } else {
            return new ResponseResult(ResultTypeEnum.OFFICE_ALREADY_EXIST);
        }
        return new ResponseResult(ResultTypeEnum.SUCCESS);
    }

    public List<ResponseOfficeFilter> findAllUsingFilter(Long orgId, String name, String phone, Boolean isActive) {
        List<OfficeEntity> offices = null;
        Specification specification = new Specification<OfficeEntity>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (null != orgId) {
                    predicates.add(criteriaBuilder.equal(root.get("organization"), orgId));
                }
                if (null != name) {
                    predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
                }
                if (null != phone) {
                    predicates.add(criteriaBuilder.equal(root.get("phone"), phone));
                }
                if (null != isActive) {
                    predicates.add(criteriaBuilder.equal(root.get("isActive"), isActive));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        offices = officeRepository.findAll(specification);
        return dtoConvertor.toDtoList(offices, ResponseOfficeFilter.class);
    }

    public Response findById(Long id) {
        if (officeRepository.existsById(id)) {
            return dtoConvertor.toDto(officeRepository.findById(id), ResponseOfficeId.class);
        } else {
            return new ResponseResult(ResultTypeEnum.NO_SUCH_OFFICE);
        }
    }

    public Response update(RequestOfficeUpdate officeUpdatedDto) {
        if (officeRepository.existsById(officeUpdatedDto.getId())){
            OfficeEntity officeEntity = officeRepository.findFirstById(officeUpdatedDto.getId());
            mapper.updateOfficeFromDto(officeUpdatedDto, officeEntity);
            officeRepository.save(officeEntity);
            return new ResponseResult(ResultTypeEnum.SUCCESS);
        } else {
            return new ResponseResult(ResultTypeEnum.NO_SUCH_OFFICE);
        }
    }
}
