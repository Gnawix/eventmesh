package org.apache.eventmesh.connector.txt.source.config;

import lombok.Data;

@Data
public class SourceConnectorConfig {
    private String connectorName;
    private String txtPath;
}
