package com.heystyles.notificacion.api.service.impl;

import com.heystyles.common.service.ConverterService;
import com.heystyles.notificacion.api.entity.ConfiguracionAlertaEntity;
import com.heystyles.notificacion.api.entity.ConfiguracionAlertaPadreEntity;
import com.heystyles.notificacion.api.service.ConfiguracionAlertaPadreService;
import com.heystyles.notificacion.core.domain.ConfiguracionAlerta;
import com.heystyles.notificacion.core.domain.TipoConfiguracionAlerta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public abstract class ConfiguracionAlertaPadreServieImpl<T extends ConfiguracionAlertaPadreEntity>
        implements ConfiguracionAlertaPadreService {

    @Autowired
    private ConverterService converterService;

    private Class<T> domainEntity = (Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    @Override
    public void upsert(TipoConfiguracionAlerta tipoConfiguracionAlerta,
                       Long tablaRelacionadaId, List<ConfiguracionAlerta> configuracionAlertas) {
        if (configuracionAlertas == null || tipoConfiguracionAlerta.compareTo(getTipo()) != 0) {
            return;
        }

        List<T> existing = getExisting(tablaRelacionadaId);

        List<T> toDelete = new ArrayList<>();
        List<T> toSave = new ArrayList<>();

        Set<Long> oldMarcasIds = existing
                .stream()
                .map(e -> e.getConfiguracionAlerta().getId())
                .collect(Collectors.toSet());

        Set<Long> configuracinesAlertasIds = configuracionAlertas
                .stream()
                .map(e -> e.getId())
                .collect(Collectors.toSet());

        existing.stream()
                .filter(p -> !configuracinesAlertasIds.contains(p.getConfiguracionAlerta().getId()))
                .forEach(p -> toDelete.add(p));

        configuracinesAlertasIds.stream()
                .filter(l -> !oldMarcasIds.contains(l))
                .forEach(l -> {
                    T entity = crearInstancia();
                    if (entity != null) {
                        entity.setConfiguracionAlerta(new ConfiguracionAlertaEntity(l));
                        entity.setTablaRelacionadaId(tablaRelacionadaId);
                        toSave.add(entity);
                    }
                });

        getDao().delete(toDelete);
        getDao().save(toSave);
    }

    @Override
    public List<ConfiguracionAlerta> findConfiguracionAlertaByTablaRelacionadaId(Long tablaRelacionadaId) {
        List<T> existing = getExisting(tablaRelacionadaId);
        return converterService.convertTo(existing, ConfiguracionAlerta.class);
    }

    public abstract CrudRepository<T, Long> getDao();

    public abstract TipoConfiguracionAlerta getTipo();

    public abstract List<T> getExisting(Long tablaRelacionadaId);


    private T crearInstancia() {
        try {
            return domainEntity.newInstance();
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
