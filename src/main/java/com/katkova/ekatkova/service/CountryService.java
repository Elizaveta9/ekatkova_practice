package com.katkova.ekatkova.service;

import com.katkova.ekatkova.dto.ResponseCountry;
import com.katkova.ekatkova.entity.CountryEntity;
import com.katkova.ekatkova.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private DtoConvertor dtoConvertor;

    public List<ResponseCountry> getCountries() {
        List<CountryEntity> countries = countryRepository.findAll();
        return dtoConvertor.toDtoList(countries, ResponseCountry.class);
    }
}
