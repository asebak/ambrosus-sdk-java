package com.ambrosus.java.example;

import com.ambrosus.java.AmbrosusSdk;
import com.ambrosus.java.AmbrosusSettings;
import com.ambrosus.java.model.NodeInfo;
import com.ambrosus.java.model.asset.Asset;
import com.ambrosus.java.model.event.Datum;
import com.ambrosus.java.model.event.Event;
import com.ambrosus.java.model.event.EventList;
import com.ambrosus.java.model.event.EventType;
import com.ambrosus.java.model.options.EventOptions;

import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        AmbrosusSdk sdk = new AmbrosusSdk(new AmbrosusSettings("", "")
                );

        NodeInfo info = sdk.getNodeInfo();
        Asset asset = sdk.createAsset();
        Asset assetById = sdk.getAssetById(asset.getAssetId());
        EventOptions options = new EventOptions();
        options.setCreatedBy(sdk.getSettings().getAddress());
        EventList events = sdk.getEvents(options);
        Event eventWithId = sdk.getEventById(events.getResults().get(0).getEventId());


        Datum datum = new Datum();
        datum.setType(EventType.Info.getValue());
        datum.setAdditionalData(new HashMap<String, Object>() {{
            put("productdesctiption","java code");
        }});

        sdk.createEvent(assetById.getAssetId(), Collections.singletonList(
            datum
        ));

    }
}
