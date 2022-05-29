package com.katkova.ekatkova.service;

import com.katkova.ekatkova.dto.ResponseCountry;
import com.katkova.ekatkova.entity.CountryEntity;
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
}
