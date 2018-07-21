package com.ambrosus.java;

import lombok.Getter;

@Getter
public class AmbrosusSettings {

    private final String apiEndpoint;
    private final String address;
    private final String secret;

    public AmbrosusSettings(String Address, String Secret) {

        this.apiEndpoint = "https://gateway-test.ambrosus.com";
        address = Address;
        secret = Secret;
    }

    public AmbrosusSettings(String apiEndpoint, String Address, String Secret) {

        this.apiEndpoint = apiEndpoint;
        address = Address;
        secret = Secret;
    }
}
