package com.ambrosus.java.model.event;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class IdData {
    private int accessLevel;
    private String assetId;
    private String createdBy;
    private long timestamp;
    private String dataHash;
}
