package com.oip.eventscollectorservice.service.device;

import com.oip.avro.DeviceEvent;

import java.util.List;

/**
 *
 */
public interface DeviceEventService {

    List<DeviceEvent> getEventsByDeviceId(String deviceId);

    DeviceEvent saveEvent(DeviceEvent deviceEvent);
}
