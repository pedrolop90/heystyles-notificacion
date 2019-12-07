package com.heystyles.notificacion.api.service;


import com.heystyles.common.service.Service;
import com.heystyles.notificacion.core.domain.Notificacion;
import com.heystyles.notificacion.core.domain.NotificacionDto;
import com.heystyles.notificacion.core.dto.NotificacionDtoListResponse;
import com.heystyles.notificacion.core.filter.NotificacionFilter;

public interface NotificacionService extends Service<Notificacion, Long> {

    NotificacionDto getNotificacion(Long notificacionId);

    NotificacionDtoListResponse getFilter(NotificacionFilter filter);
}
