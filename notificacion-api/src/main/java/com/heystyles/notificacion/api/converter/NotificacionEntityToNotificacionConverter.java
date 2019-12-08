package com.heystyles.notificacion.api.converter;

import com.heystyles.notificacion.api.entity.NotificacionEntity;
import com.heystyles.notificacion.core.domain.Notificacion;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NotificacionEntityToNotificacionConverter
implements Converter<NotificacionEntity, Notificacion> {

    @Override
    public Notificacion convert(NotificacionEntity entity) {
        Notificacion bean = new Notificacion();
        bean.setId(entity.getId());
        bean.setNombre(entity.getNombre());
        bean.setDescripcion(entity.getDescripcion());
        bean.setUsuarioId(entity.getUsuarioId());
        bean.setEstado(entity.getEstado());
        return bean;
    }
}
