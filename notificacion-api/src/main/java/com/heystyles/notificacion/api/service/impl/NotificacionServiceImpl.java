package com.heystyles.notificacion.api.service.impl;

import com.heystyles.common.exception.APIExceptions;
import com.heystyles.common.service.impl.ServiceImpl;
import com.heystyles.common.types.Page;
import com.heystyles.notificacion.api.dao.NotificacionDao;
import com.heystyles.notificacion.api.entity.NotificacionEntity;
import com.heystyles.notificacion.api.message.MessageKeys;
import com.heystyles.notificacion.api.service.NotificacionService;
import com.heystyles.notificacion.core.domain.Notificacion;
import com.heystyles.notificacion.core.domain.NotificacionDto;
import com.heystyles.notificacion.core.dto.NotificacionDtoListResponse;
import com.heystyles.notificacion.core.filter.NotificacionFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.context.i18n.LocaleContextHolder.getLocale;

@Service
public class NotificacionServiceImpl
        extends ServiceImpl<Notificacion, NotificacionEntity, Long> implements NotificacionService {

    @Autowired
    private NotificacionDao notificacionDao;

    @Autowired
    private MessageSource messageSource;

    @Override
    protected NotificacionDao getDao() {
        return notificacionDao;
    }

    @Override
    public NotificacionDto getNotificacion(Long notificacionId) {
        NotificacionEntity notificacionEntity = Optional.ofNullable(notificacionDao.findOne(notificacionId))
                .orElseThrow(() -> APIExceptions.objetoNoEncontrado(
                        messageSource.getMessage(
                                MessageKeys.NOTIFICACION_NOT_FOUND,
                                new Object[]{notificacionId},
                                getLocale()
                        )
                ));
        return getConverterService().convertTo(notificacionEntity, NotificacionDto.class);
    }

    @Override
    public NotificacionDtoListResponse getFilter(NotificacionFilter filter) {
        filter = Optional.ofNullable(filter).orElse(new NotificacionFilter());
        Page<NotificacionEntity> page = notificacionDao.getPage(filter);
        return new NotificacionDtoListResponse(
                page.getTotalElements(),
                getConverterService().convertTo(page.getContent(), NotificacionDto.class)
        );
    }
}
