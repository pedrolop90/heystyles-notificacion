package com.heystyles.notificacion.api.converter;

import com.heystyles.common.exception.APIExceptions;
import com.heystyles.notificacion.api.dao.NotificacionDao;
import com.heystyles.notificacion.api.entity.NotificacionEntity;
import com.heystyles.notificacion.api.message.MessageKeys;
import com.heystyles.notificacion.core.domain.Notificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static org.springframework.context.i18n.LocaleContextHolder.getLocale;

@Component
public class NotificacionToNotificacioEntityConverter
        implements Converter<Notificacion, NotificacionEntity> {

    @Autowired
    private NotificacionDao notificacionDao;

    @Autowired
    private MessageSource messageSource;

    @Override
    public NotificacionEntity convert(Notificacion bean) {
        NotificacionEntity entity = null;
        if (bean.getId() == null) {
            entity = new NotificacionEntity();
        }
        else {
            entity = Optional.ofNullable(notificacionDao.findOne(bean.getId()))
                    .orElseThrow(() -> APIExceptions.objetoNoEncontrado(
                            messageSource.getMessage(
                                    MessageKeys.NOTIFICACION_NOT_FOUND,
                                    new Object[]{bean.getId()},
                                    getLocale()
                            )
                    ));
        }
        entity.setNombre(bean.getNombre());
        entity.setDescripcion(bean.getDescripcion());
        entity.setCargoId(bean.getCargoId());
        entity.setEstado(bean.getEstado());
        return entity;
    }
}
