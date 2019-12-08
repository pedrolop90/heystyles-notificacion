package com.heystyles.notificacion.api.service.impl;

import com.heystyles.notificacion.api.dao.ConfiguracionAlertaFacturaDao;
import com.heystyles.notificacion.api.entity.ConfiguracionAlertaFacturaEntity;
import com.heystyles.notificacion.api.service.ConfiguracionAlertaFacturaService;
import com.heystyles.notificacion.core.domain.TipoConfiguracionAlerta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfiguracionAlertaFacturaServiceImpl
        extends ConfiguracionAlertaPadreServieImpl<ConfiguracionAlertaFacturaEntity>
        implements ConfiguracionAlertaFacturaService {

    @Autowired
    private ConfiguracionAlertaFacturaDao configuracionAlertaFacturaDao;

    @Override
    public CrudRepository<ConfiguracionAlertaFacturaEntity, Long> getDao() {
        return configuracionAlertaFacturaDao;
    }

    @Override
    public TipoConfiguracionAlerta getTipo() {
        return TipoConfiguracionAlerta.FACTURA;
    }

    @Override
    public List<ConfiguracionAlertaFacturaEntity> getExisting(Long tablaRelacionadaId) {
        return configuracionAlertaFacturaDao.findByFacturaId(tablaRelacionadaId);
    }
}
