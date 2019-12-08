package com.heystyles.notificacion.api.entity;

import com.heystyles.common.types.AuditableWithAuthorEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "configuracion_alerta_factura")
public class ConfiguracionAlertaFacturaEntity extends ConfiguracionAlertaPadreEntity {

    public interface Attributes extends AuditableWithAuthorEntity.Attributes {

    }

    @Column(name = "id_factura", nullable = false)
    private Long facturaId;

    @Override
    public Long getTablaRelacionadaId() {
        return facturaId;
    }

    @Override
    public void setTablaRelacionadaId(Long tablaRelacionadaId) {
        facturaId = tablaRelacionadaId;
    }
}
