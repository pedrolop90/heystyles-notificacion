package com.heystyles.notificacion.core.filter;

import com.heystyles.common.filter.Filter;
import com.heystyles.common.types.Estado;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class NotificacionFilter extends Filter {

    private Long cargoId;
    private Estado estado;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaInicial;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaFinal;

    private Boolean fechaAscending;

    public Long getCargoId() {
        return cargoId;
    }

    public void setCargoId(Long cargoId) {
        this.cargoId = cargoId;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public LocalDate getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(LocalDate fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Boolean getFechaAscending() {
        return fechaAscending;
    }

    public void setFechaAscending(Boolean fechaAscending) {
        this.fechaAscending = fechaAscending;
    }
}
