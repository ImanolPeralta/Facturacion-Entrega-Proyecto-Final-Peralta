package com.comercioonline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comercioonline.models.Venta;
import com.comercioonline.services.VentaService;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

	@Autowired
    private VentaService ventaService;

    @GetMapping
    public ResponseEntity<?> obtenerTodasLasVentas() {
        try {
            List<Venta> ventas = ventaService.findAll();
            if (ventas.isEmpty()) {
                return ResponseEntity.noContent().build(); // 204
            }
            return ResponseEntity.ok(ventas); // 200
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al obtener ventas: " + e.getMessage()); // 500
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerVentaPorId(@PathVariable Long id) {
        try {
            Venta venta = ventaService.findById(id);
            return ResponseEntity.ok(venta); // 200
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body("Venta no encontrada: " + e.getMessage()); // 404
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al buscar la venta: " + e.getMessage()); // 500
        }
    }

    @PostMapping
    public ResponseEntity<?> crearVenta(@RequestBody Venta nuevaVenta) {
        try {
            Venta venta = ventaService.save(nuevaVenta);
            return ResponseEntity.status(201).body(venta); // 201
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al crear la venta: " + e.getMessage()); // 500
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarVenta(@PathVariable Long id, @RequestBody Venta ventaActualizada) {
        try {
            Venta venta = ventaService.update(id, ventaActualizada);
            return ResponseEntity.ok(venta); // 200
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body("Venta no encontrada: " + e.getMessage()); // 404
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al actualizar la venta: " + e.getMessage()); // 500
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarVenta(@PathVariable Long id) {
        try {
            ventaService.deleteById(id);
            return ResponseEntity.ok("Venta eliminada correctamente"); // 200
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body("Venta no encontrada: " + e.getMessage()); // 404
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al eliminar la venta: " + e.getMessage()); // 500
        }
    }
	
}
