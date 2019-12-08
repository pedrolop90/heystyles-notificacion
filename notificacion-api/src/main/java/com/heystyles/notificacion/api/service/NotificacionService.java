package com.heystyles.notificacion.api.service;


import com.heystyles.common.service.Service;
import com.heystyles.notificacion.core.domain.Notificacion;
import com.heystyles.notificacion.core.dto.NotificacionListResponse;
import com.heystyles.notificacion.core.filter.NotificacionFilter;

public interface NotificacionService extends Service<Notificacion, Long> {

    Notificacion getNotificacion(Long notificacionId);

    NotificacionListResponse getFilter(NotificacionFilter filter);
}
