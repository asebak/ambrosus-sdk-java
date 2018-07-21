package com.ambrosus.java.model.asset;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class Asset {
    private String assetId;
    private Content content;
    private Metadata metadata;
}
