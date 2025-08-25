package com.oip.eventscollectorservice.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 * Сущность события
 */
@Data
@Builder
@Table("device_events_by_device")
public class DeviceEventEntity {

    @PrimaryKeyColumn(name = "device_id", type = PrimaryKeyType.PARTITIONED)
    private String deviceId;

    @PrimaryKeyColumn(name = "event_id", type = PrimaryKeyType.CLUSTERED)
    private String eventId;

    @Column
    private Long timestamp;

    @Column
    private String type;

    @Column
    private String payload;
}
