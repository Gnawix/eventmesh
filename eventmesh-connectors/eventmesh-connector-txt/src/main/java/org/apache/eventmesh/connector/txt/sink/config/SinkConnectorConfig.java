package org.apache.eventmesh.connector.txt.sink.config;

import lombok.Data;

@Data
public class SinkConnectorConfig {
    private String connectorName;
    private String txtPath;
}
