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
import com.comercioonline.models.Producto;
import com.comercioonline.services.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@GetMapping
	public ResponseEntity<?> obtenerTodosLosProductos() {
        try {
            List<Producto> productos = productoService.findAll();
            return ResponseEntity.ok(productos); // 200
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al obtener productos: " + e.getMessage()); // 500
        }
    } 
	
	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerProductoPorId(@PathVariable Long id) {
		try {
			Producto producto = productoService.findById(id);
			return ResponseEntity.ok(producto); // 200 OK
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Producto no encontrado: " + e.getMessage()); // 404
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al buscar el producto: " + e.getMessage()); // 500
		}
	}
	
	@PostMapping
	public ResponseEntity<?> crearProducto(@RequestBody Producto nuevoProducto) {
		try {
			Producto producto = productoService.save(nuevoProducto);
			return ResponseEntity.status(HttpStatus.CREATED).body(producto); // 201
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Error al crear producto: " + e.getMessage()); // 400
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarProducto(@PathVariable Long id, @RequestBody Producto productoActualizado) {
		try {
			Producto producto = productoService.update(id, productoActualizado);
			return ResponseEntity.ok(producto); // 200 OK
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Producto no encontrado: " + e.getMessage()); // 404
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Error al actualizar producto: " + e.getMessage()); // 400
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarProducto(@PathVariable Long id) {
		try {
			productoService.deleteById(id);
			return ResponseEntity.noContent().build(); // 204 No Content
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Producto no encontrado: " + e.getMessage()); // 404
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al eliminar producto: " + e.getMessage()); // 500
		}
	}
 	
}
