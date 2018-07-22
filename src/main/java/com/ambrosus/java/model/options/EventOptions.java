package com.ambrosus.java.model.options;

import lombok.Data;

import java.util.Optional;

@Data
public class EventOptions {
    private String assetId;
    private Long fromTimestamp;
    private Long toTimestamp;
    private Integer page;
    private Integer perPage;
    private String createdBy;
    private String data;
}
