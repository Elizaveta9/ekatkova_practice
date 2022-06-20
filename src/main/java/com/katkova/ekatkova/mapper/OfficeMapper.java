package com.katkova.ekatkova.mapper;

import com.katkova.ekatkova.dto.RequestOfficeUpdate;
import com.katkova.ekatkova.entity.OfficeEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface OfficeMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateOfficeFromDto(RequestOfficeUpdate dto, @MappingTarget OfficeEntity entity);
}
