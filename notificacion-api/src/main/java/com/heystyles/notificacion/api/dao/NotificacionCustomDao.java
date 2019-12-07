package com.heystyles.notificacion.api.dao;

import com.heystyles.common.types.Page;
import com.heystyles.notificacion.api.entity.NotificacionEntity;
import com.heystyles.notificacion.core.filter.NotificacionFilter;

public interface NotificacionCustomDao {

    Page<NotificacionEntity> getPage(NotificacionFilter filter);

}
