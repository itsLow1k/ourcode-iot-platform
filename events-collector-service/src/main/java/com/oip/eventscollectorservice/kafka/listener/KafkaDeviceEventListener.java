package com.oip.eventscollectorservice.kafka.listener;

import com.oip.avro.DeviceEvent;
import com.oip.eventscollectorservice.service.device.DeviceEventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Слушатель сообщений из топика events
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaDeviceEventListener {

    private final DeviceEventService deviceEventService;

    @KafkaListener(topics = "events", groupId = "my-group")
    public void listen(DeviceEvent deviceEvent) {
        log.info("Received DeviceEvent {}", deviceEvent);

        deviceEventService.saveEvent(deviceEvent);

        log.info("Device Event saved Successfully");
    }
}
