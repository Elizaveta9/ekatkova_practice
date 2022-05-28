package com.katkova.ekatkova.controller;

import com.katkova.ekatkova.dto.ResponseCountry;
import com.katkova.ekatkova.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/countries")
public class CountriesController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<ResponseCountry> getCountries() {
        List<ResponseCountry> countries = countryService.getCountries();
        return countries;
    }
}
