package com.heystyles.notificacion.api.controller;

import com.heystyles.common.response.Responses;
import com.heystyles.common.types.BaseResponse;
import com.heystyles.common.types.IdResponse;
import com.heystyles.notificacion.api.service.NotificacionService;
import com.heystyles.notificacion.core.domain.Notificacion;
import com.heystyles.notificacion.core.dto.NotificacionListResponse;
import com.heystyles.notificacion.core.dto.NotificacionResponse;
import com.heystyles.notificacion.core.filter.NotificacionFilter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RequestMapping(value = "/notificaciones")
@RestController
@Api(value = "Notificacion Controller",
        description = "Controller para el manejo de las notificaciones.")
public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;

    @ApiOperation(value = "Permite Crear una Notificacion en la base de datos.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Notificacion Creada.")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IdResponse> insert(
            @NotNull @Valid @RequestBody Notificacion bean) {
        return Responses.responseEntity(new IdResponse(notificacionService.insert(bean)));
    }

    @ApiOperation(value = "Permite actualizar una Notificacion en la base de datos")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Notificacion Actualizada."),
            @ApiResponse(code = 404, message = "Notificacion no encontrada.")
    })
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> update(@NotNull @Valid @RequestBody Notificacion bean) {
        notificacionService.update(bean);
        return Responses.successEntity("Actualizacion correcta");
    }

    @ApiOperation(value = "Permite Eliminar una Notificacion de la base de datos")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Notificacion Eliminada."),
            @ApiResponse(code = 404, message = "Notificacion no encontrada.")
    })
    @DeleteMapping(value = "/{notificacionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> delete(
            @NotNull @PathVariable(name = "notificacionId") Long notificacionId) {
        notificacionService.delete(notificacionId);
        return Responses.successEntity("Eliminado correcto");
    }

    @ApiOperation(value = "Permite Buscar una Notificacion de la base de datos")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Notificacion Encontrada."),
            @ApiResponse(code = 404, message = "Notificacion no encontrada.")
    })
    @GetMapping(value = "/{notificacionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NotificacionResponse> getNotificacion(
            @NotNull @PathVariable(name = "notificacionId") Long lugarId) {
        return Responses.responseEntity(new NotificacionResponse(notificacionService.getNotificacion(lugarId)));
    }

    @ApiOperation(value = "Permite Listar todos las Notificacion de la base de datos, dado un filtro.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Notificaciones Encontradas."),
            @ApiResponse(code = 404, message = "Notificaciones no encontradas.")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NotificacionListResponse> getNotificaciones(NotificacionFilter filter) {
        return Responses.responseEntity(notificacionService.getFilter(filter));
    }

}
