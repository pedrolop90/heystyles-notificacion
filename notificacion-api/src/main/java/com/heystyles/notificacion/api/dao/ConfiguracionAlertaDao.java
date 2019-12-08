package com.heystyles.notificacion.api.dao;

import com.heystyles.notificacion.api.entity.ConfiguracionAlertaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiguracionAlertaDao
        extends JpaRepository<ConfiguracionAlertaEntity, Long> {
}
