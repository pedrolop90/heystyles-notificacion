package com.heystyles.notificacion.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.heystyles.common.types.DomainBean;
import com.heystyles.common.types.Estado;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConfiguracionAlerta extends DomainBean<Long> {

    private Long id;

    @NotBlank
    private String delay;

    @NotNull
    private ModoConfiguracionAlerta modo;

    private Estado estado;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getDelay() {
        return delay;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public ModoConfiguracionAlerta getModo() {
        return modo;
    }

    public void setModo(ModoConfiguracionAlerta modo) {
        this.modo = modo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
