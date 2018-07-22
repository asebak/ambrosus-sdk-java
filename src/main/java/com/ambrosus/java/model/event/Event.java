package com.ambrosus.java.model.event;

import com.ambrosus.java.model.asset.Metadata;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Event {

    private String eventId;
    private Content content;
    private Metadata metadata;
}
