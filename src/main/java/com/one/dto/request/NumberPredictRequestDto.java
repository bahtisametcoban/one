package com.one.dto.request;

import com.one.util.NumberEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NumberPredictRequestDto {
    private Long number;
    private char[] numberArray;


    public boolean isNumberValid() {
        numberArray= numberToCharArray(number);
        boolean isValid=true;
        if (number >= NumberEnum.MIN_NUMBER.getNumber() && number <= NumberEnum.MAX_NUMBER.getNumber()) {
            for (int i = 0; i < numberArray.length; i++) {
                for (int j = i + 1; j < numberArray.length; j++) {
                    if (numberArray[i] == numberArray[j]) {
                        isValid = false;
                        break;
                    }
                }
            }

        }
        return isValid;
    }

    public boolean isNumberNotValid() {
        return !isNumberValid();
    }

    private char[] numberToCharArray(Long number) {
        return number.toString().toCharArray();
    }
}
