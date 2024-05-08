package org.apache.eventmesh.connector.txt.sink.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.eventmesh.openconnect.api.config.SinkConfig;

@Data
@EqualsAndHashCode(callSuper = true)
public class TxtSinkConfig extends SinkConfig {
    public SinkConnectorConfig connectorConfig;
}