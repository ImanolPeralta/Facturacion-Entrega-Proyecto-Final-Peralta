package com.comercioonline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.comercioonline.models.Cliente;
import com.comercioonline.services.ClienteService;
import com.comercioonline.dto.ClienteProductoDTO;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        try {
            List<Cliente> clientes = clienteService.findAll();
            return ResponseEntity.ok(clientes); // 200
        } catch (Exception err) {
            return ResponseEntity.internalServerError().build(); // 500
        }
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long clienteId) {
        try {
            Cliente cliente = clienteService.findById(clienteId);
            return ResponseEntity.ok(cliente); // 200
        } catch (IllegalArgumentException err) {
            return ResponseEntity.notFound().build(); // 404
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        try {
            Cliente clienteCreado = clienteService.save(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteCreado); // 201
        } catch (Exception err) {
            return ResponseEntity.internalServerError().build(); // 500
        }
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> updateClienteById(@PathVariable Long clienteId, @RequestBody Cliente clienteActualizado) {
        try {
            Cliente cliente = clienteService.update(clienteId, clienteActualizado);
            return ResponseEntity.ok(cliente); // 200
        } catch (IllegalArgumentException err) {
            return ResponseEntity.notFound().build(); // 404
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
        }
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> deleteClienteById(@PathVariable Long clienteId) {
        try {
            clienteService.deleteById(clienteId);
            return ResponseEntity.noContent().build(); // 204
        } catch (IllegalArgumentException err) {
            return ResponseEntity.notFound().build(); // 404
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
        }
    }

    @PostMapping("/adquirirProducto")
    public ResponseEntity<?> adquirirClienteProductos(@RequestBody ClienteProductoDTO dto) {
        try {
        	Cliente cliente = clienteService.asociarClienteConProducto(dto);
            return ResponseEntity.ok(cliente); // 200
        } catch (IllegalStateException err) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(err.getMessage()); // 409
        } catch (IllegalArgumentException err) {
            return ResponseEntity.notFound().build(); // 404
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
        }
    }
}
