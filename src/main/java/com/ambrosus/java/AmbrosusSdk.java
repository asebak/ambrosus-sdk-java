package com.ambrosus.java;

import com.ambrosus.java.api.Assets;
import com.ambrosus.java.api.Request;
import com.ambrosus.java.model.asset.Asset;
import com.ambrosus.java.model.asset.AssetList;
import com.ambrosus.java.model.asset.Content;
import com.ambrosus.java.model.asset.IdData;
import com.ambrosus.java.model.options.AssetOptions;
import lombok.Getter;

import java.time.Instant;

import static com.ambrosus.java.Utils.isNullOrEmpty;

public class AmbrosusSdk {
    @Getter
    private AmbrosusSettings settings;
    private Assets assets;

    public AmbrosusSdk(AmbrosusSettings settings) {
        this.settings = settings;
        this.assets = new Assets(new Request(settings));
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
/*
    public Event GetEventById(string eventId)
    {
        if (string.IsNullOrEmpty(eventId))
        {
            throw new ArgumentException("eventId is required.");
        }

        return this._events.GetEventById(eventId);
    }


    public EventList GetEvents(EventOptions paramaters)
    {
        return this._events.GetEvents(paramaters);
    }



    public Event CreateEvent(string assetId, IList<Datum> eventData)
    {
        if (string.IsNullOrEmpty(assetId))
        {
            throw new ArgumentException("assetId is required.");
        }

        var param = new Event
        {
            Content = new EventContent
            {
                IdData = new EventIdData
                {
                    AssetId = assetId,
                            CreatedBy = Settings.Address,
                            AccessLevel = 0,
                            Timestamp = (Int32)(DateTime.UtcNow.Subtract(new DateTime(1970, 1, 1))).TotalSeconds
                }
            }

        };

        if (eventData != null && eventData.Count > 0)
        {
            param.Content.Data = eventData;
        }
        else
        {
            throw new ArgumentException("eventData is required.");
        }

        return this._events.CreateEvent(assetId, param);
    }

    public NodeInfo GetNodeInfo()
    {
        return _node.Information();
    }
*/
}
