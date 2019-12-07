package com.heystyles.notificacion.core.dto;

import com.heystyles.common.types.ListResponse;
import com.heystyles.notificacion.core.domain.NotificacionDto;

import java.util.List;

public class NotificacionDtoListResponse extends ListResponse<NotificacionDto> {

    public NotificacionDtoListResponse() {
    }

    public NotificacionDtoListResponse(List<NotificacionDto> notificacions) {
        super(notificacions);
    }

    public NotificacionDtoListResponse(Long count, List<NotificacionDto> notificacions) {
        super(notificacions, count);
    }
}
