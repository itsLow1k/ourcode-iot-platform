package com.oip.eventscollectorservice.kafka.producer;

import com.oip.avro.DeviceEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 *
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaDeviceIdProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void produce(DeviceEvent deviceEvent) {
        log.info("Device event for produce: {}", deviceEvent);

        String deviceId = deviceEvent.getDeviceId();
        kafkaTemplate.send("device-id-topic", deviceId);

        log.info("Device Event produced successfully");
    }
}
