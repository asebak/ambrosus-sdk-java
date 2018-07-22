package com.ambrosus.java.api;

import com.ambrosus.java.model.NodeInfo;
import com.ambrosus.java.model.event.Event;

import java.util.Optional;

public class Node {

    private IRequest request;

    public Node(IRequest request)
    {
        this.request = request;
    }

    public NodeInfo information() {
        return request.getRequest("nodeinfo", Optional.empty(), NodeInfo.class);
    }
}
