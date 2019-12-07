package com.heystyles.notificacion.core.dto;

import com.heystyles.common.types.ObjectResponse;
import com.heystyles.notificacion.core.domain.NotificacionDto;

public class NotificacionDtoResponse extends ObjectResponse<NotificacionDto> {

    public NotificacionDtoResponse() {

    }

    public NotificacionDtoResponse(NotificacionDto notificacion) {
        super(notificacion);
    }

}
