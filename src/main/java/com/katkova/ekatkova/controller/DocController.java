package com.katkova.ekatkova.controller;

import com.katkova.ekatkova.dto.ResponseDoc;
import com.katkova.ekatkova.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/docs")
public class DocController {

    @Autowired
    private DocService docService;

    @GetMapping
    public List<ResponseDoc> getDocs(){
        List<ResponseDoc> docs = docService.getDocs();
        return docs;
    }
}
