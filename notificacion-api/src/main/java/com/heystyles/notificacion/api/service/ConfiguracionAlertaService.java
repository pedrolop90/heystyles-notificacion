package com.heystyles.notificacion.api.service;

import com.heystyles.common.service.Service;
import com.heystyles.notificacion.core.domain.ConfiguracionAlerta;
import com.heystyles.notificacion.core.domain.ConfiguracionAlertaRequest;
import com.heystyles.notificacion.core.domain.TipoConfiguracionAlerta;

import java.util.List;

public interface ConfiguracionAlertaService extends Service<ConfiguracionAlerta, Long> {

    void upsert(ConfiguracionAlertaRequest request);

    List<ConfiguracionAlerta> findByTipoConfiguracionAlertaAndTablaRelacionadaId(
            TipoConfiguracionAlerta tipoConfiguracionAlerta, Long tablaRelacionadaId);

    List<TipoConfiguracionAlerta> getAllTipoConfiguracionAlerta();
}
