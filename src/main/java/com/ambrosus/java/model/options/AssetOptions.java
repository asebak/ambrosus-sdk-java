package com.ambrosus.java.model.options;

import lombok.Data;

import java.util.Optional;

@Data
public class AssetOptions {
    private Integer perPage;
    private Integer page;
    private String createdBy;
    private Long fromTimestamp;
    private Long toTimestamp;
    private String identifier;
}
