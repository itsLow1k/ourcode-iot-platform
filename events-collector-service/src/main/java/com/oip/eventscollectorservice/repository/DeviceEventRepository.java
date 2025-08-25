package com.oip.eventscollectorservice.repository;

import com.oip.eventscollectorservice.entity.DeviceEventEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceEventRepository extends CassandraRepository<DeviceEventEntity, String> {

    List<DeviceEventEntity> findByDeviceId(String deviceId);
}
