package com.one.dto.request;

import com.one.util.NumberEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NumberPredictRequestDto {
    private Long number;

    public boolean isNumberValid() {
        return number >= NumberEnum.MIN_NUMBER.getNumber() && number <= NumberEnum.MAX_NUMBER.getNumber();
    }

    public boolean isNumberNotValid() {
        return !isNumberValid();
    }
}
