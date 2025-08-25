package com.oip.eventscollectorservice.service.device.impl;

import com.oip.avro.DeviceEvent;
import com.oip.eventscollectorservice.entity.DeviceEventEntity;
import com.oip.eventscollectorservice.kafka.producer.KafkaDeviceIdProducer;
import com.oip.eventscollectorservice.mapper.DeviceEventMapper;
import com.oip.eventscollectorservice.repository.DeviceEventRepository;
import com.oip.eventscollectorservice.service.device.DeviceEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 */
@Service
@RequiredArgsConstructor
public class DeviceEventServiceImpl implements DeviceEventService {

    private final DeviceEventRepository deviceEventRepository;

    private final KafkaDeviceIdProducer kafkaDeviceIdProducer;

    public List<DeviceEvent> getEventsByDeviceId(String deviceId) {
        List<DeviceEventEntity> deviceEvents = deviceEventRepository.findByDeviceId(deviceId);

        return DeviceEventMapper.INSTANCE.toDtos(deviceEvents);
    }

    public DeviceEvent saveEvent(DeviceEvent deviceEvent) {
        DeviceEventEntity deviceEventEntity = DeviceEventMapper.INSTANCE.toEntity(deviceEvent);

        DeviceEventEntity savedDeviceEventEntity = deviceEventRepository.save(deviceEventEntity);

        DeviceEvent savedDeviceEvent = DeviceEventMapper.INSTANCE.toDto(savedDeviceEventEntity);

        kafkaDeviceIdProducer.produce(savedDeviceEvent);

        return savedDeviceEvent;
    }
}
