package com.ambrosus.java.api;


import javax.ws.rs.client.Entity;
import java.util.HashMap;
import java.util.Optional;

public interface IRequest {
    <T> T getRequest(String path, Optional<HashMap<String, Object>> queryParams, Class<T> type);

    <T> T postRequest(String path, Entity body, Class<T> type);
}
