package com.ambrosus.java.api;

import com.ambrosus.java.AmbrosusSettings;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Request implements IRequest {
    private AmbrosusSettings settings;

    public Request(AmbrosusSettings settings)
    {
        this.settings = settings;
    }

    @Override
    public <T> T getRequest(String path, Optional<HashMap<String, Object>> queryParams, Class<T> type) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget
                = client.target(settings.getApiEndpoint());
                webTarget = webTarget.path(path);

                if(queryParams.isPresent()){
                    for (Map.Entry<String, Object> entry : queryParams.get().entrySet()) {
                        webTarget = webTarget.queryParam(entry.getKey(), entry.getValue());
                    }
                }

        return webTarget.request("application/json").get(type);
    }

    @Override
    public <T> T postRequest(String path, Entity body, Class<T> type) {


        Client client = ClientBuilder.newClient().register(AmbObjectMapper.class);
        WebTarget webTarget = client.target(settings.getApiEndpoint()).path(path);


        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        String postBody  = body.toString();
        Response response = invocationBuilder.header("Authorization", "AMB " + settings.getSecret()).post(body);
        return response.readEntity(type);
    }
}
