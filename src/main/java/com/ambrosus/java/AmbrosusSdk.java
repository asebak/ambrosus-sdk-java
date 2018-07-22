package com.ambrosus.java;

import com.ambrosus.java.api.Assets;
import com.ambrosus.java.api.Events;
import com.ambrosus.java.api.Node;
import com.ambrosus.java.api.Request;
import com.ambrosus.java.model.NodeInfo;
import com.ambrosus.java.model.asset.Asset;
import com.ambrosus.java.model.asset.AssetList;
import com.ambrosus.java.model.asset.Content;
import com.ambrosus.java.model.asset.IdData;
import com.ambrosus.java.model.event.Datum;
import com.ambrosus.java.model.event.Event;
import com.ambrosus.java.model.event.EventList;
import com.ambrosus.java.model.options.AssetOptions;
import com.ambrosus.java.model.options.EventOptions;
import lombok.Getter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.ambrosus.java.Utils.isNullOrEmpty;

public class AmbrosusSdk {
    private final Events events;
    private final Node node;
    @Getter
    private AmbrosusSettings settings;
    private Assets assets;

    public AmbrosusSdk(AmbrosusSettings settings) {
        this.settings = settings;
        this.assets = new Assets(new Request(settings));
        this.events = new Events(new Request(settings));
        this.node = new Node(new Request(settings));
    }

    public AssetList getAssets(AssetOptions options)
    {
        return this.assets.GetAssets(options);
    }

    public Asset getAssetById(String assetId)
    {
        if (isNullOrEmpty(assetId))
        {
            throw new IllegalArgumentException("assetId is required.");
        }
        return this.assets.GetAssetById(assetId);
    }

    public Asset createAsset() {
        Asset asset = new Asset();
        Content content = new Content();
        IdData idData = new IdData();
        idData.setCreatedBy(settings.getAddress());
        idData.setSequenceNumber(0);
        idData.setTimestamp(Instant.now().getEpochSecond());
        asset.setContent(content);
        content.setIdData(idData);
        return this.assets.CreateAsset(asset);
    }

    public Event getEventById(String eventId)
    {
        if (isNullOrEmpty(eventId))
        {
            throw new IllegalArgumentException("eventId is required.");
        }

        return this.events.GetEventById(eventId);
    }


    public EventList getEvents(EventOptions paramaters)
    {
        return this.events.GetEvents(paramaters);
    }

    public Event createEvent(String assetId, List<Datum> eventData)
    {
        if (isNullOrEmpty(assetId))
        {
            throw new IllegalArgumentException("assetId is required.");
        }

        Event param = new Event();
        com.ambrosus.java.model.event.Content content = new com.ambrosus.java.model.event.Content();
        com.ambrosus.java.model.event.IdData idData = new com.ambrosus.java.model.event.IdData();
        idData.setAssetId(assetId);
        idData.setAccessLevel(0);
        idData.setCreatedBy(settings.getAddress());
        idData.setTimestamp(Instant.now().getEpochSecond());
        content.setIdData(idData);
        param.setContent(content);

        if (eventData != null && eventData.size() > 0)
        {
            param.getContent().setData(eventData);
        }
        else
        {
            throw new IllegalArgumentException("eventData is required.");
        }

        return this.events.CreateEvent(assetId, param);
    }



    public NodeInfo getNodeInfo()
    {
        return node.information();
    }

}
