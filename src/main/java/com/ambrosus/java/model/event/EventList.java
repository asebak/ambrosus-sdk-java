package com.ambrosus.java.model.event;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@Data
public class EventList {
    private ArrayList<Event> results;
    private int resultCount;
}
