package com.ambrosus.java.model.asset;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IdData {
    private String createdBy;
    private long timestamp;
    private int sequenceNumber;
}
