package com.katkova.ekatkova.service;

import com.katkova.ekatkova.dto.ResponseCountry;
import com.katkova.ekatkova.entity.CountryEntity;
import com.katkova.ekatkova.repository.CountryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CountryRepository countryRepository;

    public List<ResponseCountry> getCountries() {
        List<CountryEntity> countries = countryRepository.findAll();
        return toDtoList(countries);
    }

    private List<ResponseCountry> toDtoList(List<CountryEntity> source) {
        return source
                .stream()
                .map(element -> mapper.map(element, ResponseCountry.class))
                .collect(Collectors.toList());
    }
}
