package com.heystyles.notificacion.api.entity;

import com.heystyles.common.types.AuditableWithAuthorEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "configuracion_alerta_producto")
public class ConfiguracionAlertaProductoEntity extends ConfiguracionAlertaPadreEntity {

    public interface Attributes extends AuditableWithAuthorEntity.Attributes {

    }

    @Column(name = "id_producto", nullable = false)
    private Long productoId;

    @Override
    public Long getTablaRelacionadaId() {
        return productoId;
    }

    @Override
    public void setTablaRelacionadaId(Long tablaRelacionadaId) {
        productoId = tablaRelacionadaId;
    }
}
