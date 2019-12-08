package com.heystyles.notificacion.core.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.heystyles.common.exception.InvalidEnumValueException;
import com.heystyles.notificacion.api.service.ConfiguracionAlertaFacturaService;
import com.heystyles.notificacion.api.service.ConfiguracionAlertaPadreService;
import com.heystyles.notificacion.api.service.ConfiguracionAlertaProductoService;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum TipoConfiguracionAlerta {

    FACTURA(ConfiguracionAlertaFacturaService.class),
    PRODUCTO(ConfiguracionAlertaProductoService.class);

    private Class<? extends ConfiguracionAlertaPadreService> serviceClass;

    TipoConfiguracionAlerta(Class<? extends ConfiguracionAlertaPadreService> serviceClass) {
        this.serviceClass = serviceClass;
    }

    public Class<? extends ConfiguracionAlertaPadreService> getServiceClass() {
        return serviceClass;
    }

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
