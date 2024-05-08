package org.apache.eventmesh.connector.txt.sink.connector;

import org.apache.eventmesh.connector.txt.sink.config.TxtSinkConfig;
import org.apache.eventmesh.connector.txt.source.config.TxtSourceConfig;
import org.apache.eventmesh.openconnect.api.config.Config;
import org.apache.eventmesh.openconnect.api.connector.ConnectorContext;
import org.apache.eventmesh.openconnect.api.connector.SinkConnectorContext;
import org.apache.eventmesh.openconnect.api.sink.Sink;
import org.apache.eventmesh.openconnect.offsetmgmt.api.data.ConnectRecord;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TxtSinkConnector implements Sink {

    private TxtSinkConfig sinkConfig;

    private String txtFileName;

    @Override
    public Class<? extends Config> configClass() {
        return TxtSinkConfig.class;
    }

    @Override
    public void init(Config config) throws Exception {

    }

    @Override
    public void init(ConnectorContext connectorContext) throws Exception {
        SinkConnectorContext sinkConnectorContext = (SinkConnectorContext) connectorContext;
        this.sinkConfig = (TxtSinkConfig) sinkConnectorContext.getSinkConfig();
        this.txtFileName = sinkConfig.getConnectorConfig().getTxtPath();
    }

    @Override
    public void start() throws Exception {

    }

    @Override
    public void commit(ConnectRecord record) {

    }

    @Override
    public String name() {
        return sinkConfig.getConnectorConfig().getConnectorName();
    }

    @Override
    public void stop() throws Exception {

    }

    @Override
    public void put(List<ConnectRecord> sinkRecords) {
        for (ConnectRecord sinkRecord : sinkRecords) {
            byte[] data = (byte[]) sinkRecord.getData();

            String line = new String(data);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(txtFileName, true))) {
                writer.write(line);
                writer.newLine(); // 换行
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
