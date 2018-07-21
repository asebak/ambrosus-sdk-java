package com.ambrosus.java.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
public class AmbObjectMapper implements ContextResolver<ObjectMapper> {

    final ObjectMapper mapper;

    public AmbObjectMapper() {
        mapper = new ObjectMapper();
       mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return mapper;
    }
}