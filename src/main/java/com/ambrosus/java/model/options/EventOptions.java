package com.ambrosus.java.model.options;

import lombok.Data;

import java.util.Optional;

@Data
public class EventOptions {
    private Optional<String> assetId;
    private Optional<Long> fromTimestamp;
    private Optional<Long> toTimestamp;
    private Optional<Integer> page;
    private Optional<Integer> perPage;
    private Optional<String> createdBy;
    private Optional<String> data;
}
