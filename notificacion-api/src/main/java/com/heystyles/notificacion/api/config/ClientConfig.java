package com.heystyles.notificacion.api.config;

import com.heystyles.common.response.ClientResponseErrorHandler;
import com.heystyles.usuarios.cliente.CargoClient;
import com.heystyles.usuarios.cliente.impl.CargoClienteImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientConfig {

    @Autowired
    private ClientProperties clientProperties;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .setConnectTimeout(clientProperties.getConnectionTimeout())
                .setReadTimeout(clientProperties.getReadTimeout())
                .errorHandler(new ClientResponseErrorHandler())
                .build();
    }

    @Bean
    public CargoClient cargoClient(RestTemplate restTemplate) {
        return new CargoClienteImpl(clientProperties.getUsuariosUrlBase(), restTemplate);
    }
}
