package com.own.consumermetricsapp.metrics.consumer;

import com.own.consumermetricsapp.metrics.infra.DeviceRepository;
import com.own.consumermetricsapp.metrics.model.DeviceMetric;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class MetricMessageReceiverTest {

    private MetricMessageReceiver metricMessageReceiver;
    private final DeviceRepository deviceRepository = mock(DeviceRepository.class);

    @BeforeEach
    public void setup(){
        metricMessageReceiver = new MetricMessageReceiver(deviceRepository);
    }

    @Test
    public void mustSaveEventInDatabase(){
        var deviceMetric = new DeviceMetric();

        metricMessageReceiver.receiveMessage(deviceMetric);

        verify(deviceRepository, atLeast(1)).save(deviceMetric);
    }

}