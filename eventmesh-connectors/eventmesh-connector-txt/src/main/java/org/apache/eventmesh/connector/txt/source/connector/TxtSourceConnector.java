package org.apache.eventmesh.connector.txt.source.connector;

import org.apache.eventmesh.connector.txt.source.config.TxtSourceConfig;
import org.apache.eventmesh.openconnect.api.config.Config;
import org.apache.eventmesh.openconnect.api.connector.ConnectorContext;
import org.apache.eventmesh.openconnect.api.connector.SourceConnectorContext;
import org.apache.eventmesh.openconnect.api.source.Source;
import org.apache.eventmesh.openconnect.offsetmgmt.api.data.ConnectRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TxtSourceConnector implements Source {

    private TxtSourceConfig sourceConfig;
    private String txtFileName;
    private int startLine = 1;

    @Override
    public Class<? extends Config> configClass() {
        return TxtSourceConfig.class;
    }

    @Override
    public void init(Config config) throws Exception {

    }

    @Override
    public void init(ConnectorContext connectorContext) throws Exception {
        SourceConnectorContext sourceConnectorContext = (SourceConnectorContext) connectorContext;
        this.sourceConfig = (TxtSourceConfig) sourceConnectorContext.getSourceConfig();
        this.txtFileName = sourceConfig.getConnectorConfig().getTxtPath();
    }

    @Override
    public void start() throws Exception {

    }

    @Override
    public void commit(ConnectRecord record) {

    }

    @Override
    public String name() {
        return this.sourceConfig.getConnectorConfig().getConnectorName();
    }

    @Override
    public void stop() throws Exception {

    }

    @Override
    public List<ConnectRecord> poll() {
        List<ConnectRecord> connectRecords = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(txtFileName))) {
            String line;
            int lineNum = 0;
            while ((line = reader.readLine()) != null) {
                lineNum++;
                if (lineNum < startLine) {
                    continue; // 跳过前面的行
                }
                ConnectRecord connectRecord = new ConnectRecord(null, null, System.currentTimeMillis(), line);
                connectRecords.add(connectRecord);
                startLine++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return connectRecords;
    }

}
