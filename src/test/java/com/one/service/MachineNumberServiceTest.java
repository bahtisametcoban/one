package com.one.service;

import com.one.dto.request.NumberPredictRequestDto;
import com.one.dto.response.NumberPredictResponseDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class MachineNumberServiceTest {

    @InjectMocks
    MachineNumberService service;

    @Test
    public void shouldGetEstimatedNumberResult() throws Exception {
        NumberPredictRequestDto dto = NumberPredictRequestDto.builder().number(1020L).build();
        NumberPredictResponseDto estimatedNumberResult = service.getEstimatedNumberResult(1234L, dto);
        assertEquals(estimatedNumberResult.getNumber(), dto.getNumber());
        assertEquals(estimatedNumberResult.getCountOfPositiveNumbers(), 1);
        assertEquals(estimatedNumberResult.getCountOfNegativeNumbers(), 1);
    }

}