package com.heystyles.notificacion.api.dao;

import com.heystyles.notificacion.api.entity.NotificacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacionDao
        extends JpaRepository<NotificacionEntity, Long>, NotificacionCustomDao {
}
