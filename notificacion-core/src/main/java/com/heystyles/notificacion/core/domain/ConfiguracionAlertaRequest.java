package com.heystyles.notificacion.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConfiguracionAlertaRequest {

    @NotNull
    @Valid
    private List<ConfiguracionAlerta> configuracionAlerta;

    @NotNull
    private TipoConfiguracionAlerta tipo;

    @NotNull
    private Long tablaRelacionadaId;

    public List<ConfiguracionAlerta> getConfiguracionAlerta() {
        return configuracionAlerta;
    }

    public void setConfiguracionAlerta(List<ConfiguracionAlerta> configuracionAlerta) {
        this.configuracionAlerta = configuracionAlerta;
    }

    public TipoConfiguracionAlerta getTipo() {
        return tipo;
    }

    public void setTipo(TipoConfiguracionAlerta tipo) {
        this.tipo = tipo;
    }

    public Long getTablaRelacionadaId() {
        return tablaRelacionadaId;
    }

    public void setTablaRelacionadaId(Long tablaRelacionadaId) {
        this.tablaRelacionadaId = tablaRelacionadaId;
    }
}
