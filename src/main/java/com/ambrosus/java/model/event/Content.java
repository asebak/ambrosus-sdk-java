package com.ambrosus.java.model.event;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class Content {
    private String signature;
    private IdData idData;
    private List<Datum> data;
}
