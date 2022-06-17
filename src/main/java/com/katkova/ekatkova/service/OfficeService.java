package com.katkova.ekatkova.service;

import com.katkova.ekatkova.dto.RequestOfficeSave;
import com.katkova.ekatkova.dto.Response;
import com.katkova.ekatkova.dto.ResponseResult;
import com.katkova.ekatkova.entity.OfficeEntity;
import com.katkova.ekatkova.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficeService {
    @Autowired
    private OfficeRepository officeRepository;

    @Autowired
    private DtoConvertor dtoConvertor;

    public Response save(RequestOfficeSave officeDto) {
        OfficeEntity officeEntity = dtoConvertor.toEntity(officeDto, OfficeEntity.class);
        if (!officeRepository.existsByNameAndPhone(officeEntity.getName(), officeEntity.getPhone())) {
            officeRepository.save(officeEntity);
        } else {
            return new ResponseResult(ResultTypeEnum.OFFICE_ALREADY_EXIST);
        }
        return new ResponseResult(ResultTypeEnum.SUCCESS);
    }
}
