package com.one.dto.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NumberPredictResponseDto {

    private Long number;
    private int countOfPositiveNumbers;
    private int countOfNegativeNumbers;

}
