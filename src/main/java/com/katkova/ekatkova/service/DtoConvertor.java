package com.katkova.ekatkova.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DtoConvertor {
    @Autowired
    private ModelMapper mapper;

    public <S, T> List<T> toDtoList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> mapper.map(element, targetClass))
                .collect(Collectors.toList());
    }

    public <S, T> T toEntity(S dto, Class<T> entityClass) {
        return mapper.map(dto, entityClass);
    }

    public <S, T> T toDto(S entity, Class<T> dtoClass) {
        return mapper.map(entity, dtoClass);
    }

    public <S, T> void updateFromDto(S updatedEntity, T needUpdateEntity) {
        mapper.map(updatedEntity, needUpdateEntity);
    }
}
