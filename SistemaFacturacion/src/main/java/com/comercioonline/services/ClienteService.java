package com.comercioonline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercioonline.dto.ClienteProductoDTO;
import com.comercioonline.interfaces.CrudInterface;
import com.comercioonline.models.Cliente;
import com.comercioonline.models.Producto;
import com.comercioonline.repositories.ClienteRepository;
import com.comercioonline.repositories.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService implements CrudInterface<Cliente, Long> {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}
	
	@Override
	public Cliente findById(Long id) {
		return clienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
	}
	
	@Override
	@Transactional
	public Cliente save(Cliente nuevoCliente) {
		return clienteRepository.save(nuevoCliente);
	}
	
	@Override
	@Transactional
	public Cliente update(Long id, Cliente clienteActualizado) {
		Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
		
		if (clienteActualizado.getNombre() != null && !clienteActualizado.getNombre().isEmpty()) {
			cliente.setNombre(clienteActualizado.getNombre());
		}
		if (clienteActualizado.getApellido() != null && !clienteActualizado.getApellido().isEmpty()) {
			cliente.setApellido(clienteActualizado.getApellido());
		}
		if (clienteActualizado.getDni() != 0) {
			cliente.setDni(clienteActualizado.getDni());
		}
		if (clienteActualizado.getDomicilio() != null && !clienteActualizado.getDomicilio().isEmpty()) {
			cliente.setDomicilio(clienteActualizado.getDomicilio());
		}
		if (clienteActualizado.getEmail() != null && !clienteActualizado.getEmail().isEmpty()) {
			cliente.setEmail(clienteActualizado.getEmail());
		}
		if (clienteActualizado.getCodigoPostal() != 0) {
			cliente.setCodigoPostal(clienteActualizado.getCodigoPostal());
		}
		if (clienteActualizado.getTelefono() != 0) {
			cliente.setTelefono(clienteActualizado.getTelefono());
		}
		
		return clienteRepository.save(cliente);
	}
	
	@Override
	public void deleteById(Long id) {
		if(!clienteRepository.existsById(id)) {
			throw new IllegalArgumentException("Cliente no encontrado");
		}
		clienteRepository.deleteById(id);
	}
	
	@Transactional
	public Cliente asociarClienteConProducto(ClienteProductoDTO dto) {
		Cliente cliente = clienteRepository.findById(dto.getClienteId()).orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
		
		for (Long productoId : dto.getProductoIds()) {
			Producto producto = productoRepository.findById(productoId).orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
			
			// Verificar que el cliente haya adquirido ese producto
			if(cliente.getProductos().contains(producto)) {
				throw new IllegalStateException("El cliente ya adquirió previamente ese producto con ID: " + productoId);
			}
			
			cliente.getProductos().add(producto);
			producto.getClientes().add(cliente);
			productoRepository.save(producto);
		}
	
	return clienteRepository.save(cliente);
	
	}
	
}
