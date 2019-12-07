package com.heystyles.notificacion.core.domain;

import com.heystyles.usuarios.core.domain.Cargo;

public class NotificacionDto {

    private Long id;
    private Cargo cargo;
    private String nombre;
    private String descripcion;
    private NotificacionEstado estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public NotificacionEstado getEstado() {
        return estado;
    }

    public void setEstado(NotificacionEstado estado) {
        this.estado = estado;
    }
}
