package com.oip.eventscollectorservice.mapper;

import com.oip.avro.DeviceEvent;
import com.oip.eventscollectorservice.entity.DeviceEventEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DeviceEventMapper {

    DeviceEventMapper INSTANCE = Mappers.getMapper(DeviceEventMapper.class);

    DeviceEvent toDto(DeviceEventEntity deviceEvent);

    List<DeviceEvent> toDtos(List<DeviceEventEntity> deviceEvent);

    DeviceEventEntity toEntity(DeviceEvent deviceEventDto);

    List<DeviceEventEntity> toEntities(List<DeviceEvent> deviceEventDto);
}
