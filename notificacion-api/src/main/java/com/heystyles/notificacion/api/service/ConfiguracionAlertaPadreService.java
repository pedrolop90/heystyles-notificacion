package com.heystyles.notificacion.api.service;

import com.heystyles.notificacion.core.domain.ConfiguracionAlerta;
import com.heystyles.notificacion.core.domain.TipoConfiguracionAlerta;

import java.util.List;

public interface ConfiguracionAlertaPadreService {

    void upsert(TipoConfiguracionAlerta tipoConfiguracionAlerta,
                Long tablaRelacionadaId, List<ConfiguracionAlerta> configuracionAlertas);

    List<ConfiguracionAlerta> findConfiguracionAlertaByTablaRelacionadaId(Long tablaRelacionadaId);
}
