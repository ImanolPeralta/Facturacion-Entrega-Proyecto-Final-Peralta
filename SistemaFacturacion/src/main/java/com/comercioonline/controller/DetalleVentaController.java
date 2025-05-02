package com.comercioonline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comercioonline.models.DetalleVenta;
import com.comercioonline.services.DetalleVentaService;

@RestController
@RequestMapping("/api/detalles-venta")
public class DetalleVentaController {
	
	@Autowired
    private DetalleVentaService detalleVentaService;

    @GetMapping
    public ResponseEntity<?> obtenerTodos() {
        try {
            List<DetalleVenta> detalles = detalleVentaService.findAll();
            if (detalles.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204
            }
            return ResponseEntity.ok(detalles); // 200
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al obtener detalles de venta: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
        try {
            DetalleVenta detalle = detalleVentaService.findById(id);
            return ResponseEntity.ok(detalle); // 200
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Detalle no encontrado: " + e.getMessage()); // 404
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al obtener detalle: " + e.getMessage()); // 500
        }
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody DetalleVenta nuevoDetalle) {
        try {
            DetalleVenta creado = detalleVentaService.save(nuevoDetalle);
            return ResponseEntity.status(HttpStatus.CREATED).body(creado); // 201
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al crear detalle: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody DetalleVenta detalleActualizado) {
        try {
            DetalleVenta actualizado = detalleVentaService.update(id, detalleActualizado);
            return ResponseEntity.ok(actualizado); // 200
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Detalle no encontrado: " + e.getMessage()); // 404
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al actualizar detalle: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            detalleVentaService.deleteById(id);
            return ResponseEntity.ok("Detalle de venta eliminado correctamente"); // 200
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Detalle no encontrado: " + e.getMessage()); // 404
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al eliminar detalle: " + e.getMessage());
        }
    }

}
