package com.oip.eventscollectorservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic deviceIdTopic() {
        return new NewTopic("device-id-topic", 1, (short) 1); // 1 partition, 1 replication factor
    }
}
