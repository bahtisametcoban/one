package com.one.controller;

import com.one.dto.request.NumberPredictRequestDto;
import com.one.dto.response.NumberPredictResponseDto;
import com.one.model.Machine;
import com.one.service.MachineNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberController {

    private static final String START_END_POINT = "/start";
    private static final String PREDICT_END_POINT = "/predict";
    private static Long machineNumber;

    @Autowired
    private MachineNumberService service;

    @RequestMapping(value = START_END_POINT, method = RequestMethod.GET)
    public void start() {
        Machine machine = new Machine();
        machineNumber = machine.prepareNumber();
    }

    @RequestMapping(value = PREDICT_END_POINT, method = RequestMethod.POST)
    public ResponseEntity<NumberPredictResponseDto> sendEstimatedNumber(@RequestBody NumberPredictRequestDto numberPredictRequestDto) {
        if(numberPredictRequestDto.isNumberNotValid()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(service.getEstimatedNumberResult(machineNumber, numberPredictRequestDto), HttpStatus.OK);
    }
}
