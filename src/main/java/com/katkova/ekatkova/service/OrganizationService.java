package com.katkova.ekatkova.service;

import com.katkova.ekatkova.dto.RequestOrganizationSave;
import com.katkova.ekatkova.entity.OrganizationEntity;
import com.katkova.ekatkova.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
