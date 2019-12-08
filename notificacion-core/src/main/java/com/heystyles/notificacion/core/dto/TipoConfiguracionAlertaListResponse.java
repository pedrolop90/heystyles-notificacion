package com.heystyles.notificacion.core.dto;

import com.heystyles.common.types.ListResponse;
import com.heystyles.notificacion.core.domain.TipoConfiguracionAlerta;

import java.util.List;

public class TipoConfiguracionAlertaListResponse
        extends ListResponse<TipoConfiguracionAlerta> {

    public TipoConfiguracionAlertaListResponse() {
        super();
    }

    public TipoConfiguracionAlertaListResponse(List<TipoConfiguracionAlerta> tipos) {
        super(tipos);
    }
}
