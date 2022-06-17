package com.katkova.ekatkova.service;

import com.katkova.ekatkova.dto.*;
import com.katkova.ekatkova.entity.OrganizationEntity;
import com.katkova.ekatkova.mapper.OrganizationMapper;
import com.katkova.ekatkova.repository.OrganizationRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        name = name.toUpperCase();
        List<OrganizationEntity> organizationEntities = organizationRepository.findAll(
                OrganizationRepository.hasNameLike(name)
                        .or(OrganizationRepository.hasInn(inn))
                        .or(OrganizationRepository.hasKpp(kpp)));
        return dtoConvertor.toDtoList(organizationEntities, ResponseOrganizationFilter.class);
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
