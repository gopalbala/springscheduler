package com.kandhanlabs;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;
import com.google.common.annotations.Beta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by gbalasubramanian on 03/06/17.
 */
@Component
@Slf4j
public class CassandraInitializer {
    private Cluster cluster;

    private Session session;

    @PostConstruct
    public void connect() {
        Cluster.Builder builder = Cluster.builder().addContactPoint("127.0.0.1");
        //builder.withPort(9160);
        cluster = builder.build();

        Metadata metadata = cluster.getMetadata();
        log.info("Cluster name: " + metadata.getClusterName());

        for (Host host : metadata.getAllHosts()) {
            log.info("Datacenter: " + host.getDatacenter() + " Host: " + host.getAddress() + " Rack: " + host.getRack());
        }
        session = cluster.connect();
    }

    @Bean
    public Session getSession() {
        return this.session;
    }

    public void close() {
        if (!session.isClosed())
            session.close();
        if (!cluster.isClosed())
            cluster.close();
    }
}
