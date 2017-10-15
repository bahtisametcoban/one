package com.one.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Machine {

    private Long number;

    public Long prepareNumber() {
        this.number = RandomUtils.nextLong(1000, 9999);
        return number;
    }
}
