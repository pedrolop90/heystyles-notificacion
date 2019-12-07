package com.heystyles.notificacion.core.dto;

import com.heystyles.common.types.ListResponse;
import com.heystyles.notificacion.core.domain.Notificacion;

import java.util.List;

public class NotificacionListResponse extends ListResponse<Notificacion> {

    public NotificacionListResponse() {
    }

    public NotificacionListResponse(List<Notificacion> notificacions) {
        super(notificacions);
    }

    public NotificacionListResponse(Long count, List<Notificacion> notificacions) {
        super(notificacions, count);
    }
}
