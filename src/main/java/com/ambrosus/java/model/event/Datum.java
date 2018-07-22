package com.ambrosus.java.model.event;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor
@Data
public class Datum {
    private String Type;
    private Map<String, Object> additionalData = new HashMap<String, Object>();

   @JsonAnySetter
    private void setDynamicProperty(String name, Object value) {
       additionalData.put(name, value);
    }

}
