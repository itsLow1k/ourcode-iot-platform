package com.oip.eventscollectorservice.config;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
public class CassandraConfig {
    private static final String KEYSPACE = "app_keyspace";

    @Bean
    public CqlSession cqlSession() {
        // Сначала создаём keyspace
        createKeyspaceIfNotExists();

        // Подключаемся к keyspace
        return CqlSession.builder()
            .withKeyspace(KEYSPACE)
            .build();
    }

    private void createKeyspaceIfNotExists() {
        try (CqlSession session = CqlSession.builder().build()) {
            session.execute("CREATE KEYSPACE IF NOT EXISTS " + KEYSPACE +
                " WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1}");
        }
    }
}
