package com.heystyles.notificacion.api.service.impl;

import com.heystyles.notificacion.api.dao.ConfiguracionAlertaProductoDao;
import com.heystyles.notificacion.api.entity.ConfiguracionAlertaProductoEntity;
import com.heystyles.notificacion.api.service.ConfiguracionAlertaProductoService;
import com.heystyles.notificacion.core.domain.TipoConfiguracionAlerta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfiguracionAlertaProductoServiceImpl
        extends ConfiguracionAlertaPadreServieImpl<ConfiguracionAlertaProductoEntity>
        implements ConfiguracionAlertaProductoService {

    @Autowired
    private ConfiguracionAlertaProductoDao configuracionAlertaProductoDao;

    @Override
    public CrudRepository<ConfiguracionAlertaProductoEntity, Long> getDao() {
        return configuracionAlertaProductoDao;
    }

    @Override
    public TipoConfiguracionAlerta getTipo() {
        return TipoConfiguracionAlerta.PRODUCTO;
    }

    @Override
    public List<ConfiguracionAlertaProductoEntity> getExisting(Long tablaRelacionadaId) {
        return configuracionAlertaProductoDao.findByProductoId(tablaRelacionadaId);
    }
}
