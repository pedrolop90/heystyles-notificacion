package com.heystyles.notificacion.api.dao;

import com.heystyles.notificacion.api.entity.ConfiguracionAlertaProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfiguracionAlertaProductoDao
        extends JpaRepository<ConfiguracionAlertaProductoEntity, Long> {

    List<ConfiguracionAlertaProductoEntity> findByProductoId(Long productoId);

}
