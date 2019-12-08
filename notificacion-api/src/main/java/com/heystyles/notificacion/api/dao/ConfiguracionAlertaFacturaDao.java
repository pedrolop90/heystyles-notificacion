package com.heystyles.notificacion.api.dao;

import com.heystyles.notificacion.api.entity.ConfiguracionAlertaFacturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfiguracionAlertaFacturaDao
        extends JpaRepository<ConfiguracionAlertaFacturaEntity, Long> {

    List<ConfiguracionAlertaFacturaEntity> findByFacturaId(Long facturaId);

}
