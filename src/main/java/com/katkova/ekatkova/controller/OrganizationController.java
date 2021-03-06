package com.katkova.ekatkova.controller;

import com.katkova.ekatkova.dto.*;
import com.katkova.ekatkova.service.OrganizationService;
import com.katkova.ekatkova.service.ResultTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @PostMapping("/save")
    public ResponseResult saveOrganization(@RequestBody @Valid RequestOrganizationSave organization,
                                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseResult(ResultTypeEnum.PARAMETER_IS_MISSING_OR_EMPTY);
        }
        if (organizationService.hasInn(organization.getInn())) {
            return new ResponseResult(ResultTypeEnum.INN_ALREADY_REGISTERED);
        }
        return organizationService.save(organization);

    }

    @GetMapping("/list")
    public List<ResponseOrganizationFilter> findOrganizationByFilter(@RequestParam(required = true) String name,
                                                                     @RequestParam(required = false) String inn,
                                                                     @RequestParam(required = false) String kpp) {
        return organizationService.findAllUsingFilter(name, inn, kpp);
    }

    @GetMapping("/{id}")
    public Response findOrganizationById(@PathVariable Long id) {
        ResponseOrganizationId organizationDto = organizationService.findById(id);
        if (organizationDto == null) {
            return new ResponseResult(ResultTypeEnum.NO_SUCH_ORGANIZATION);
        } else {
            return organizationDto;
        }
    }

    @PostMapping("/update")
    public Response updateOrganization(@RequestBody RequestOrganizationUpdate organization){
        return organizationService.update(organization);
    }

}
