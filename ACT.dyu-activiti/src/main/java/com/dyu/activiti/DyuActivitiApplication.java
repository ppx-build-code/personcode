package com.dyu.activiti;

import com.dyu.activiti.service.ProcessRuntimeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.context.WebApplicationContext;

@EnableScheduling
@SpringBootApplication
public class DyuActivitiApplication {

    public static void main(String[] args) {
        WebApplicationContext applicationContext = (WebApplicationContext) SpringApplication.run(DyuActivitiApplication.class, args);
        ProcessRuntimeService processRuntimeService = (ProcessRuntimeService) applicationContext.getBean("processRuntimeService");
        processRuntimeService.run();
    }
}
