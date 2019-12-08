package com.heystyles.notificacion.core.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.heystyles.common.exception.InvalidEnumValueException;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum TipoConfiguracionAlerta {

    FACTURA, PRODUCTO;

    @JsonValue
    public String getValue() {
        return name();
    }

    @JsonCreator
    public static TipoConfiguracionAlerta fromValue(String value) {
        if (value != null && value.isEmpty()) {
            return null;
        }
        for (TipoConfiguracionAlerta p : values()) {
            if (p.name().equals(value)) {
                return p;
            }
        }
        throw new InvalidEnumValueException("TipoConfiguracionAlerta", value);
    }

}
