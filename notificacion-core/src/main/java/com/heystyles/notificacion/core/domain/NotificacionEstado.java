package com.heystyles.notificacion.core.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.heystyles.common.exception.InvalidEnumValueException;

@JsonFormat(
        shape = JsonFormat.Shape.STRING
)
public enum NotificacionEstado {

    SIN_LEER, LEIDO;

    @JsonValue
    public String getValue() {
        return name();
    }

    @JsonCreator
    public static NotificacionEstado fromValue(String value) {
        if (value != null && value.isEmpty()) {
            return null;
        }
        for (NotificacionEstado p : values()) {
            if (p.name().equals(value)) {
                return p;
            }
        }
        throw new InvalidEnumValueException("NotificacionEstado", value);
    }

}
