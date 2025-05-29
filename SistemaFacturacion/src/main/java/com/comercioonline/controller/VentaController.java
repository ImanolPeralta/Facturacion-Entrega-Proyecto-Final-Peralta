package com.comercioonline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.comercioonline.dto.ComprobanteRequestDTO;
import com.comercioonline.models.Venta;
import com.comercioonline.services.VentaService;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/api/ventas")
@Tag(name = "Gestión de Ventas", description = "Operaciones CRUD para ventas registradas.")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @Operation(summary = "Obtener todas las ventas")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Ventas obtenidas correctamente",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Venta.class))),
        @ApiResponse(responseCode = "204", description = "No hay ventas registradas", content = @Content),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtenerTodasLasVentas() {
        try {
            List<Venta> ventas = ventaService.findAll();
            if (ventas.isEmpty()) {
                return ResponseEntity.noContent().build(); // 204
            }
            return ResponseEntity.ok(ventas); // 200
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al obtener ventas: " + e.getMessage());
        }
    }

    @Operation(summary = "Obtener una venta por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Venta encontrada",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Venta.class))),
        @ApiResponse(responseCode = "404", description = "Venta no encontrada", content = @Content),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtenerVentaPorId(@PathVariable Long id) {
        try {
            Venta venta = ventaService.findById(id);
            return ResponseEntity.ok(venta); // 200
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body("Venta no encontrada: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al buscar la venta: " + e.getMessage());
        }
    }

    @Operation(summary = "Crear una venta desde un comprobante")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Venta creada correctamente desde comprobante",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Venta.class))),
        @ApiResponse(responseCode = "400", description = "Datos inválidos en el comprobante", content = @Content),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
    })
    @PostMapping(value = "/comprobante", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> crearVentaDesdeComprobante(@RequestBody ComprobanteRequestDTO request) {
        try {
            Venta venta = ventaService.crearVentaDesdeComprobante(request);
            return ResponseEntity.status(201).body(venta);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error de validación: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al crear la venta: " + e.getMessage());
        }
    }



    @Operation(summary = "Actualizar una venta existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Venta actualizada correctamente",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Venta.class))),
        @ApiResponse(responseCode = "404", description = "Venta no encontrada", content = @Content),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
    })
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> actualizarVenta(@PathVariable Long id, @RequestBody Venta ventaActualizada) {
        try {
            Venta venta = ventaService.update(id, ventaActualizada);
            return ResponseEntity.ok(venta); // 200
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body("Venta no encontrada: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al actualizar la venta: " + e.getMessage());
        }
    }

    @Operation(summary = "Eliminar una venta por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Venta eliminada correctamente"),
        @ApiResponse(responseCode = "404", description = "Venta no encontrada", content = @Content),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarVenta(@PathVariable Long id) {
        try {
            ventaService.deleteById(id);
            return ResponseEntity.ok("Venta eliminada correctamente"); // 200
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body("Venta no encontrada: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al eliminar la venta: " + e.getMessage());
        }
    }
}
