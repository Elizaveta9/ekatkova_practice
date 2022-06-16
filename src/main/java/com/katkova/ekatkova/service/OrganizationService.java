package com.katkova.ekatkova.service;

import com.katkova.ekatkova.dto.RequestOrganizationSave;
import com.katkova.ekatkova.dto.ResponseOrganizationFilter;
import com.katkova.ekatkova.dto.ResponseOrganizationId;
import com.katkova.ekatkova.entity.OrganizationEntity;
import com.katkova.ekatkova.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private DtoConvertor dtoConvertor;

    public void save(RequestOrganizationSave organizationDto) {
        OrganizationEntity organizationEntity = dtoConvertor.toEntity(organizationDto, OrganizationEntity.class);
        organizationRepository.save(organizationEntity);
    }

    public boolean hasInn(String inn) {
        OrganizationEntity organizationEntity = organizationRepository.findByInn(inn);
        return organizationEntity != null;
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
        if (organizationEntity == null){
            return null;
        }
        return dtoConvertor.toDto(organizationEntity, ResponseOrganizationId.class);
    }
}