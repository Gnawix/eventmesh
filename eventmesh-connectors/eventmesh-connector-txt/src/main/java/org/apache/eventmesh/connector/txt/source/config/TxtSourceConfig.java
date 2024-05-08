package org.apache.eventmesh.connector.txt.source.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.eventmesh.openconnect.api.config.SourceConfig;

@Data
@EqualsAndHashCode(callSuper = true)
public class TxtSourceConfig extends SourceConfig {
    public SourceConnectorConfig connectorConfig;
}
