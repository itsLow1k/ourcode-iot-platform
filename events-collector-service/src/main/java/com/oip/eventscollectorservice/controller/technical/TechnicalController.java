package com.oip.eventscollectorservice.controller.technical;

import com.oip.avro.DeviceEvent;
import com.oip.eventscollectorservice.service.device.DeviceEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TechnicalController {

    private final DeviceEventService deviceEventService;

    @PostMapping
    public ResponseEntity<DeviceEvent> post() {
        DeviceEvent deviceEvent = new DeviceEvent();

        deviceEvent.setDeviceId("1");
        deviceEvent.setEventId("123");
        deviceEvent.setType("a");
        deviceEvent.setPayload("b");
        deviceEvent.setTimestamp(System.currentTimeMillis());

        DeviceEvent deviceEvent1 = deviceEventService.saveEvent(deviceEvent);

        return ResponseEntity.ok(deviceEvent1);
    }
}
