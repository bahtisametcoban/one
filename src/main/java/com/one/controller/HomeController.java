package com.one.controller;

import com.one.dto.NumberPredictRequestDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private static final String PREDICT_END_POINT = "/predict";

    @RequestMapping(value = PREDICT_END_POINT, method = RequestMethod.POST)
    public String home(@RequestBody NumberPredictRequestDto numberPredictRequestDto) {
        return numberPredictRequestDto.getNumber() + " SAMET ";
    }
}
