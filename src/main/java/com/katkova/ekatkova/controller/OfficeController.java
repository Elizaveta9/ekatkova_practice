package com.katkova.ekatkova.controller;

import com.katkova.ekatkova.dto.RequestOfficeSave;
import com.katkova.ekatkova.dto.Response;
import com.katkova.ekatkova.dto.ResponseOfficeFilter;
import com.katkova.ekatkova.service.OfficeService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/office")
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    @PostMapping("/save")
    public Response saveOffice(@RequestBody RequestOfficeSave office) {
        return officeService.save(office);
    }

    @GetMapping("/list")
    public List<ResponseOfficeFilter> findOfficeUsingFilter(@RequestParam(required = true) Long orgId,
                                                             @RequestParam(required = false) String name,
                                                             @RequestParam(required = false) String phone,
                                                             @RequestParam(required = false) Boolean isActive){
        return officeService.findAllUsingFilter(orgId, name, phone,isActive);
    }

    @GetMapping("/{id}")
    public Response findOfficeById(@PathVariable Long id){
        return officeService.findById(id);
    }
}
