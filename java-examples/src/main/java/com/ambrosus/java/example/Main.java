package com.ambrosus.java.example;

import com.ambrosus.java.AmbrosusSdk;
import com.ambrosus.java.AmbrosusSettings;
import com.ambrosus.java.model.asset.Asset;
import com.ambrosus.java.model.asset.AssetList;
import com.ambrosus.java.model.options.AssetOptions;

public class Main {
    public static void main(String[] args) {
 
        Asset asset = sdk.createAsset();
        Asset assetById = sdk.getAssetById(asset.getAssetId());

    }
}
