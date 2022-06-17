package com.katkova.ekatkova.controller;

import com.katkova.ekatkova.dto.RequestOfficeSave;
import com.katkova.ekatkova.dto.Response;
import com.katkova.ekatkova.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/office")
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    @PostMapping("/save")
    public Response saveOffice(@RequestBody RequestOfficeSave office) {
        return officeService.save(office);
    }
}
