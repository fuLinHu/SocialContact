package com.xunwu.es.project.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by 瓦力.
 */
@Configuration
public class ElasticSearchConfig {
    @Value("${elasticsearch.host}")
    private String esHost;

    @Value("${elasticsearch.port}")
    private int esPort;

    @Value("${elasticsearch.cluster.name}")
    private String esName;

    @Bean
    public TransportClient esClient() throws UnknownHostException {
        Settings settings = Settings.builder()
                .put("cluster.name", this.esName)
//                .put("cluster.name", "elasticsearch")
                .put("client.transport.sniff", true)//打开探嗅功能  当新的节点进入时，可以不用重新启动
                .build();

        InetSocketTransportAddress master = new InetSocketTransportAddress(
            InetAddress.getByName(esHost), esPort
//          InetAddress.getByName("10.99.207.76"), 8999
        );
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(master);
        return client;
    }
}
