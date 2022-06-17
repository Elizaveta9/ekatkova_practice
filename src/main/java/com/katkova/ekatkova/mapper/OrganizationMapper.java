package com.katkova.ekatkova.mapper;

import com.katkova.ekatkova.dto.RequestOrganizationUpdate;
import com.katkova.ekatkova.entity.OrganizationEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateOrganizationFromDto(RequestOrganizationUpdate dto, @MappingTarget OrganizationEntity entity);
}
