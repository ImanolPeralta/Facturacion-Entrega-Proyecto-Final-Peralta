package com.comercioonline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.comercioonline.models.DetalleVenta;
import com.comercioonline.services.DetalleVentaService;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/api/detalles-venta")
@Tag(name = "Gestión de Detalles de Venta", description = "Operaciones CRUD para detalles de venta.")
public class DetalleVentaController {
    
    @Autowired
    private DetalleVentaService detalleVentaService;

    @Operation(summary = "Obtener todos los detalles de venta")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Detalles encontrados correctamente",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = DetalleVenta.class))),
        @ApiResponse(responseCode = "204", description = "No hay detalles disponibles", content = @Content),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtenerTodos() {
        try {
            List<DetalleVenta> detalles = detalleVentaService.findAll();
            if (detalles.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.ok(detalles);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al obtener detalles de venta: " + e.getMessage());
        }
    }

    @Operation(summary = "Obtener un detalle de venta por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Detalle encontrado",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = DetalleVenta.class))),
        @ApiResponse(responseCode = "404", description = "Detalle no encontrado", content = @Content),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
        try {
            DetalleVenta detalle = detalleVentaService.findById(id);
            return ResponseEntity.ok(detalle);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Detalle no encontrado: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al obtener detalle: " + e.getMessage());
        }
    }

    @Operation(summary = "Crear un nuevo detalle de venta")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Detalle creado correctamente",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = DetalleVenta.class))),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> crear(@RequestBody DetalleVenta nuevoDetalle) {
        try {
            DetalleVenta creado = detalleVentaService.save(nuevoDetalle);
            return ResponseEntity.status(HttpStatus.CREATED).body(creado);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al crear detalle: " + e.getMessage());
        }
    }

    @Operation(summary = "Actualizar un detalle de venta por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Detalle actualizado correctamente",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = DetalleVenta.class))),
        @ApiResponse(responseCode = "404", description = "Detalle no encontrado", content = @Content),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
    })
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody DetalleVenta detalleActualizado) {
        try {
            DetalleVenta actualizado = detalleVentaService.update(id, detalleActualizado);
            return ResponseEntity.ok(actualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Detalle no encontrado: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al actualizar detalle: " + e.getMessage());
        }
    }

    @Operation(summary = "Eliminar un detalle de venta por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Detalle eliminado correctamente"),
        @ApiResponse(responseCode = "404", description = "Detalle no encontrado", content = @Content),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            detalleVentaService.deleteById(id);
            return ResponseEntity.ok("Detalle de venta eliminado correctamente");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Detalle no encontrado: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al eliminar detalle: " + e.getMessage());
        }
    }
}

