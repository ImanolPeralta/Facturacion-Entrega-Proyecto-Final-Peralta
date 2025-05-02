package com.comercioonline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercioonline.interfaces.CrudInterface;
import com.comercioonline.models.Venta;
import com.comercioonline.repositories.VentaRepository;

import jakarta.transaction.Transactional;

@Service
public class VentaService implements CrudInterface<Venta, Long> {

	@Autowired
	private VentaRepository ventaRepository;
	
	@Override
	public List<Venta> findAll() {
		return ventaRepository.findAll();
	}
	
	@Override
	public Venta findById(Long id) {
		return ventaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Venta no encontrada"));
	}
	
	@Override
	@Transactional
    public Venta save(Venta nuevaVenta) {
        return ventaRepository.save(nuevaVenta);
    }
	
	@Override
	@Transactional
	public Venta update(Long id, Venta ventaActualizada) {
		Venta venta = ventaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Venta no encontrada"));
		
		if(ventaActualizada.getCreatedAt() != null) {
			venta.setCreatedAt(ventaActualizada.getCreatedAt());
		}
		if(ventaActualizada.getCliente() != null && !ventaActualizada.getCliente().isEmpty()) {
			venta.setCliente(ventaActualizada.getCliente());
		}
		if(ventaActualizada.getTotal() > 0) {
			venta.setTotal(ventaActualizada.getTotal());
		}
		if(ventaActualizada.getDetalleVenta() != null && !ventaActualizada.getDetalleVenta().isEmpty()) {
			venta.setDetalleVenta(ventaActualizada.getDetalleVenta());
		}
		
		return ventaRepository.save(venta);
	}
	
	@Override
	public void deleteById(Long id) {
		if(!ventaRepository.existsById(id)) {
			throw new IllegalArgumentException("Venta no encontrada");
		}
		
		ventaRepository.deleteById(id);
	}
}
