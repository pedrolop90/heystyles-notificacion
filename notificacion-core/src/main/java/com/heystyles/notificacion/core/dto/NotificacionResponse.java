package com.heystyles.notificacion.core.dto;

import com.heystyles.common.types.ObjectResponse;
import com.heystyles.notificacion.core.domain.Notificacion;

public class NotificacionResponse extends ObjectResponse<Notificacion> {

    public NotificacionResponse() {

    }

    public NotificacionResponse(Notificacion notificacion) {
        super(notificacion);
    }

}
