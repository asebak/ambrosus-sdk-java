package com.ambrosus.java.model.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class EventType {
    @Getter
    private final String value;

    public static EventType Info = new EventType("ambrosus.asset.info");
    public static EventType AssetIdentifiers = new EventType("ambrosus.asset.identifiers");
    public static EventType EventIdentifiers = new EventType("ambrosus.event.identifiers");
    public static EventType EventLocation = new EventType("ambrosus.event.location");
    public static EventType EventGeoLocation = new EventType("ambrosus.event.location.geo");
    public static EventType AssetLocation = new EventType("ambrosus.asset.location.asset");
    public static EventType EventAssetLocation = new EventType("ambrosus.event.location.asset");
    public static EventType Serialisation = new EventType("ambrosus.asset.serialisation");
    public static EventType Expiration = new EventType("ambrosus.consumables.expiration");
    public static EventType Temperature = new EventType("ambrosus.sensor.temperature");
    public static EventType Pressure = new EventType("ambrosus.sensor.pressure");
    public static EventType Humidity = new EventType("ambrosus.sensor.humidity");
    public static EventType Acceleration = new EventType("ambrosus.sensor.acceleration");
    public static EventType Orientation = new EventType("ambrosus.sensor.orientation");
}
