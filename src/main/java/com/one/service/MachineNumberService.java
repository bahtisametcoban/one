package com.one.service;

import com.one.dto.request.NumberPredictRequestDto;
import com.one.dto.response.NumberPredictResponseDto;
import org.springframework.stereotype.Service;

@Service
public class MachineNumberService {

    private char[] machineChars;
    private char[] numberChars;

    public NumberPredictResponseDto getEstimatedNumberResult(final Long machineNumber, NumberPredictRequestDto numberPredictRequestDto) {
        machineChars = numberToCharArray(machineNumber);
        numberChars = numberToCharArray(numberPredictRequestDto.getNumber());
        return NumberPredictResponseDto.builder().number(numberPredictRequestDto.getNumber())
                .countOfNegativeNumbers(calculateNegatives())
                .countOfPositiveNumbers(calculatePositives())
                .build();
    }

    private int calculatePositives() {
        int positives = 0;
        for (int i = 0; i < machineChars.length; i++) {
            if(machineChars[i] == numberChars[i]) {
                positives++;
            }
        }
        return positives;
    }

    private int calculateNegatives() {
        int negatives = 0;
        for (int i = 0; i < machineChars.length; i++) {
            for (int j = 0; j < numberChars.length; j++) {
                if(i != j && machineChars[i] == numberChars[j]) {
                    negatives++;
                }
            }
        }
        return negatives;
    }

    private char[] numberToCharArray(Long number) {
        return number.toString().toCharArray();
    }
}
