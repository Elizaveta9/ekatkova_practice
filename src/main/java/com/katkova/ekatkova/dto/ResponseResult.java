package com.katkova.ekatkova.dto;

import com.katkova.ekatkova.service.ResultTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
public class ResponseResult implements Response {
    private String result;

    public ResponseResult(ResultTypeEnum result) {
        this.result = result.getResult();
    }
}
