package com.heystyles.notificacion.api.converter;

import com.heystyles.notificacion.api.entity.NotificacionEntity;
import com.heystyles.notificacion.core.domain.NotificacionDto;
import com.heystyles.usuarios.cliente.CargoClient;
import com.heystyles.usuarios.core.domain.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NotificacionEntityToNotificacionDtoConverter
implements Converter<NotificacionEntity, NotificacionDto> {

    @Autowired
    private CargoClient cargoClient;

    @Override
    public NotificacionDto convert(NotificacionEntity entity) {
        NotificacionDto dto = new NotificacionDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setDescripcion(entity.getDescripcion());
        Cargo cargo = cargoClient.getCargo(entity.getCargoId());
        dto.setCargo(cargo);
        dto.setEstado(entity.getEstado());
        return dto;
    }
}
