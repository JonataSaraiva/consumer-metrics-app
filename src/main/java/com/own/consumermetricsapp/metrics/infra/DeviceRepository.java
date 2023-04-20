package com.own.consumermetricsapp.metrics.infra;

import com.own.consumermetricsapp.metrics.model.DeviceMetric;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface DeviceRepository extends ElasticsearchRepository<DeviceMetric, String> {

}