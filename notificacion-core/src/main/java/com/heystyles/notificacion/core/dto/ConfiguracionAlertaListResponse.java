package com.heystyles.notificacion.core.dto;

import com.heystyles.common.types.ListResponse;
import com.heystyles.notificacion.core.domain.ConfiguracionAlerta;

import java.util.List;

public class ConfiguracionAlertaListResponse extends ListResponse<ConfiguracionAlerta> {

    public ConfiguracionAlertaListResponse() {
    }

    public ConfiguracionAlertaListResponse(List<ConfiguracionAlerta> configuracionAlertas) {
        super(configuracionAlertas);
    }

    public ConfiguracionAlertaListResponse(Long count, List<ConfiguracionAlerta> configuracionAlertas) {
        super(configuracionAlertas, count);
    }
}
