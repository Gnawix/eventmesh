package org.apache.eventmesh.connector.txt.server;

import org.apache.eventmesh.connector.txt.config.TxtServerConfig;
import org.apache.eventmesh.connector.txt.sink.connector.TxtSinkConnector;
import org.apache.eventmesh.connector.txt.source.connector.TxtSourceConnector;
import org.apache.eventmesh.openconnect.Application;
import org.apache.eventmesh.openconnect.util.ConfigUtil;

public class TxtConnectorServer {
    public static void main(String[] args) throws Exception {

        TxtServerConfig serverConfig = ConfigUtil.parse(TxtServerConfig.class, "server-config.yml");

        if (serverConfig.isSourceEnable()) {
            Application txtSourceApp = new Application();
            txtSourceApp.run(TxtSourceConnector.class);
        }

        if (serverConfig.isSinkEnable()) {
            Application txtSinkApp = new Application();
            txtSinkApp.run(TxtSinkConnector.class);
        }
    }
}
