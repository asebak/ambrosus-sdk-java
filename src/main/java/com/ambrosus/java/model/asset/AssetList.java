package com.ambrosus.java.model.asset;


import lombok.Data;

import java.util.ArrayList;

@Data
public class AssetList {
    private ArrayList<Asset> results;
    private int resultCount;
}
