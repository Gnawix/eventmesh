package org.apache.eventmesh.connector.txt.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.eventmesh.openconnect.api.config.Config;

@Data
@EqualsAndHashCode(callSuper = true)
public class TxtServerConfig extends Config {

    private boolean sourceEnable;

    private boolean sinkEnable;

}