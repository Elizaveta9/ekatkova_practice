package com.katkova.ekatkova.service;

import com.katkova.ekatkova.dto.ResponseDoc;
import com.katkova.ekatkova.entity.DocEntity;
import com.katkova.ekatkova.repository.DocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocService {

    @Autowired
    private DocRepository docRepository;

    @Autowired
    private DtoConvertor dtoConvertor;

    public List<ResponseDoc> getDocs(){
        List<DocEntity> docs = docRepository.findAll();
        return dtoConvertor.toDtoList(docs, ResponseDoc.class);
    }
}
