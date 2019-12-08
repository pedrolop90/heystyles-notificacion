package com.heystyles.notificacion.api.controller;

import com.heystyles.common.response.Responses;
import com.heystyles.common.types.BaseResponse;
import com.heystyles.notificacion.api.service.ConfiguracionAlertaService;
import com.heystyles.notificacion.core.domain.ConfiguracionAlertaRequest;
import com.heystyles.notificacion.core.domain.TipoConfiguracionAlerta;
import com.heystyles.notificacion.core.dto.ConfiguracionAlertaListResponse;
import com.heystyles.notificacion.core.dto.TipoConfiguracionAlertaListResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RequestMapping(value = "/configuracion-alerta")
@RestController
@Api(value = "Configuracion Alerta Controller",
        description = "Controller para el manejo de las Configuraciones de Alertas.")
public class ConfiguracionAlertaController {

    @Autowired
    private ConfiguracionAlertaService service;

    @ApiOperation(value = "Permite Registrar o Actualizar Configuraciones de Alertas en la base de datos.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Configuraciones de Alertas Registrar o Actualizar.")
    })
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse upsert(@NotNull @Valid @RequestBody ConfiguracionAlertaRequest request) {
        service.upsert(request);
        return Responses.success("Actualizacion Exitosa");
    }

    @ApiOperation(value = "Permite Listar todos las configuraciones de alertas,"
            + " dado su tipo de configuracion y tablaRelacionadaId")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Configuraciones de Alertas Encontradas."),
            @ApiResponse(code = 404, message = "Configuraciones de Alertas no encontradas.")
    })
    @GetMapping(value = "/{tablaRelacionadaId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConfiguracionAlertaListResponse> getConfiguracionesAlertas(
            @NotNull @PathVariable Long tablaRelacionadaId,
            @NotNull TipoConfiguracionAlerta tipoConfiguracionAlerta) {
        return Responses.responseEntity(new ConfiguracionAlertaListResponse(
                service.findByTipoConfiguracionAlertaAndTablaRelacionadaId(
                        tipoConfiguracionAlerta, tablaRelacionadaId
                )
        ));
    }

    @ApiOperation(value = "Permite Listar todos los tipos de configuraciones de alertas.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Tipos de Configuraciones Encontradas."),
            @ApiResponse(code = 404, message = "Tipos de Configuraciones no encontradas.")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TipoConfiguracionAlertaListResponse> getTipoConfiguracionesAlertas() {
        return Responses.responseEntity(new TipoConfiguracionAlertaListResponse(
                service.getAllTipoConfiguracionAlerta()
        ));
    }

}
