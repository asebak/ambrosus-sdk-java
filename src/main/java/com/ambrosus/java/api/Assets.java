package com.ambrosus.java.api;

import com.ambrosus.java.Utils;
import com.ambrosus.java.model.asset.Asset;
import com.ambrosus.java.model.asset.AssetList;
import com.ambrosus.java.model.options.AssetOptions;

import javax.ws.rs.client.Entity;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

public class Assets {

    private IRequest request;

    public Assets(IRequest request)
    {
        this.request = request;
    }

    public AssetList GetAssets(AssetOptions options)
    {
        HashMap<String, Object> hashMap = new HashMap<String, Object>() {
            {
                put("perPage", options.getPerPage());
                put("createdBy", options.getCreatedBy());
                put("identifier", options.getIdentifier());
                put("fromTimestamp", options.getFromTimestamp());
                put("toTimestamp", options.getToTimestamp());
                put("page", options.getPage());
            }
        };

        hashMap.values().removeIf(Objects::isNull);
        Optional<HashMap<String, Object>> oHash =  hashMap.size() == 0 ? Optional.empty() : Optional.of(hashMap);

        AssetList assets = request.getRequest("assets", oHash, AssetList.class);

        return assets;
    }


    public Asset GetAssetById(String assetId)
    {
        Asset asset = request.getRequest("assets/" + assetId, Optional.empty(), Asset.class);
        return asset;
    }

    public Asset CreateAsset(Asset asset)
    {
        return request.postRequest("assets", Entity.json(asset), Asset.class);
    }
}
