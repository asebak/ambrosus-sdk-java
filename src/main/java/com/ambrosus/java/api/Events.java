package com.ambrosus.java.api;

import com.ambrosus.java.model.event.Event;
import com.ambrosus.java.model.event.EventList;
import com.ambrosus.java.model.options.EventOptions;

import javax.ws.rs.client.Entity;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

public class Events {

    private IRequest request;

    public Events(IRequest request)
    {
        this.request = request;
    }

    public EventList GetEvents(EventOptions options)
    {

        HashMap<String, Object> hashMap = new HashMap<String, Object>() {
            {
                put("assetId", options.getAssetId());
                put("data", options.getData());
                put("fromTimestamp", options.getFromTimestamp());
                put("toTimestamp", options.getToTimestamp());
                put("createdBy", options.getCreatedBy());
                put("page", options.getPage());
            }
        };

        hashMap.values().removeIf(Objects::isNull);
        Optional<HashMap<String, Object>> oHash =  hashMap.size() == 0 ? Optional.empty() : Optional.of(hashMap);


        return request.getRequest("events", oHash, EventList.class);
    }


    public Event GetEventById(String eventId)
    {
        return request.getRequest("events/" + eventId, Optional.empty(), Event.class);
    }

    public Event CreateEvent(String assetId, Event eve)
    {
        return request.postRequest("assets/"  + assetId + "/events", Entity.json(eve), Event.class);
    }
}
