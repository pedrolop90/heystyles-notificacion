package com.heystyles.notificacion.api.service.impl;

import com.heystyles.common.service.impl.ServiceImpl;
import com.heystyles.notificacion.api.dao.ConfiguracionAlertaDao;
import com.heystyles.notificacion.api.entity.ConfiguracionAlertaEntity;
import com.heystyles.notificacion.api.service.ConfiguracionAlertaFacturaService;
import com.heystyles.notificacion.api.service.ConfiguracionAlertaProductoService;
import com.heystyles.notificacion.api.service.ConfiguracionAlertaService;
import com.heystyles.notificacion.core.domain.ConfiguracionAlerta;
import com.heystyles.notificacion.core.domain.ConfiguracionAlertaRequest;
import com.heystyles.notificacion.core.domain.TipoConfiguracionAlerta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ConfiguracionAlertaServiceImpl
        extends ServiceImpl<ConfiguracionAlerta, ConfiguracionAlertaEntity, Long>
        implements ConfiguracionAlertaService {

    @Autowired
    private ConfiguracionAlertaDao configuracionAlertaDao;

    @Autowired
    private ConfiguracionAlertaFacturaService configuracionAlertaFacturaService;

    @Autowired
    private ConfiguracionAlertaProductoService configuracionAlertaProductoService;

    @Override
    protected ConfiguracionAlertaDao getDao() {
        return configuracionAlertaDao;
    }

    @Override
    public void upsert(ConfiguracionAlertaRequest request) {
        Long tablaRelacionadaId = request.getTablaRelacionadaId();
        TipoConfiguracionAlerta tipo = request.getTipo();
        List<ConfiguracionAlerta> configuracionAlertas = request.getConfiguracionAlerta();
        if (configuracionAlertas == null) {
            return;
        }
        configuracionAlertaFacturaService.upsert(tipo, tablaRelacionadaId, configuracionAlertas);
        configuracionAlertaProductoService.upsert(tipo, tablaRelacionadaId, configuracionAlertas);
    }

    @Override
    public List<ConfiguracionAlerta> findByTipoConfiguracionAlertaAndTablaRelacionadaId(
            TipoConfiguracionAlerta tipo, Long tablaRelacionadaId) {
        if (tipo.compareTo(TipoConfiguracionAlerta.FACTURA) == 0) {
            return configuracionAlertaFacturaService.findConfiguracionAlertaByTablaRelacionadaId(tablaRelacionadaId);
        }
        else {
            return configuracionAlertaProductoService.findConfiguracionAlertaByTablaRelacionadaId(tablaRelacionadaId);
        }
    }

    @Override
    public List<TipoConfiguracionAlerta> getAllTipoConfiguracionAlerta() {
        return Arrays.asList(TipoConfiguracionAlerta.values());
    }
}
