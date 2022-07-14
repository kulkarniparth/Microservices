package com.example.newrelic.model;

//import io.micrometer.core.instrument.Metrics;
import com.newrelic.telemetry.micrometer.NewRelicRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/transfer")
public class MetricsController {


    @Autowired
    NewRelicRegistry newRelicRegistry;

    @GetMapping("/v1")
    public void transferFile(){
        long x = new Random().nextInt(10);
        System.out.println("Transferred " + x + "files");
//        Metrics.counter("files.transferred").increment(x);
        newRelicRegistry.counter("files.transferred").increment(x);
        System.out.println("Metric counter noted");
    }
}
