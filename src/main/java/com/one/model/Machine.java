package com.one.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Machine {

    private Long number;

    public Long prepareNumber() {
        List<Integer> uniqueArrayList = prepareUniqueArrayList();
        this.number = convertArrayListToNumber(uniqueArrayList);
        return number;
    }

    private List<Integer> prepareUniqueArrayList() {
        List<Integer> list = new ArrayList<>();
        int newNumber;
        int index = 0;
        for(;index < 4;index++) {
            if(index == 0) {
                newNumber = RandomUtils.nextInt(1,9);
                list.add(newNumber);
            } else {
                newNumber = RandomUtils.nextInt(0,9);
                while(list.contains(newNumber)) {
                    newNumber = RandomUtils.nextInt(0,9);
                }
                list.add(newNumber);
            }
        }
        return list;
    }

    private Long convertArrayListToNumber(List<Integer> list) {
        int i = list.get(0) * 1000 + list.get(1) * 100 + list.get(2) * 10 + list.get(3);
        return (long) i;
    }
}
