package com.ambrosus.java.model.asset;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Metadata {
    private String bundleId;
    private String bundleTransactionHash;
    private String entityUploadTimestamp;
}
