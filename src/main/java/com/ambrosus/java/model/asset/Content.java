package com.ambrosus.java.model.asset;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Content {
    public String signature;
    public IdData idData;
}
