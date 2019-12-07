package com.heystyles.notificacion.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
        "com.heystyles.notificacion.api.async",
        "com.heystyles.notificacion.api.config",
        "com.heystyles.notificacion.api.controller",
        "com.heystyles.notificacion.api.converter",
        "com.heystyles.notificacion.api.dao",
        "com.heystyles.notificacion.api.entity",
        "com.heystyles.notificacion.api.service",
        "com.heystyles.notificacion.api.exception",
        "com.heystyles.notificacion.api.http",
        "com.heystyles.notificacion.api.message",
        "com.heystyles.notificacion.api.service",
        "com.heystyles.notificacion.api.validator",
})
@SpringBootApplication
public class NotificacionApp extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(NotificacionApp.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(NotificacionApp.class, args);
    }

}
