package com.own.consumermetricsapp.metrics.consumer;

import com.own.consumermetricsapp.metrics.infra.DeviceRepository;
import com.own.consumermetricsapp.metrics.model.DeviceMetric;
import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MetricMessageReceiver {

    private final DeviceRepository deviceRepository;

    public MetricMessageReceiver(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @SqsListener(value = "http://localhost:4566/000000000000/metric-received", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receiveMessage(DeviceMetric deviceMetric) {
        deviceRepository.save(deviceMetric);
        log.info("Message saved with payload {}", deviceMetric);
    }

}