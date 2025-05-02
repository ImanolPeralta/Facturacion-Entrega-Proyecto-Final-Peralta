package com.comercioonline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercioonline.interfaces.CrudInterface;
import com.comercioonline.models.DetalleVenta;
import com.comercioonline.repositories.DetalleVentaRepository;

import jakarta.transaction.Transactional;

@Service
public class DetalleVentaService implements CrudInterface<DetalleVenta, Long> {

	@Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Override
    public DetalleVenta findById(Long id) {
        return detalleVentaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Detalle de venta no encontrado"));
    }

    @Override
    public List<DetalleVenta> findAll() {
        return detalleVentaRepository.findAll();
    }

    @Override
    @Transactional
    public DetalleVenta save(DetalleVenta nuevoDetalle) {
        return detalleVentaRepository.save(nuevoDetalle);
    }

    @Override
    @Transactional
    public DetalleVenta update(Long id, DetalleVenta detalleActualizado) {
        DetalleVenta detalle = detalleVentaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Detalle de venta no encontrado"));

        if (detalleActualizado.getProducto() != null && !detalleActualizado.getProducto().isEmpty()) {
            detalle.setProducto(detalleActualizado.getProducto());
        }
        if (detalleActualizado.getCantidad() > 0) {
            detalle.setCantidad(detalleActualizado.getCantidad());
        }
        if (detalleActualizado.getPrecioUnitario() > 0) {
            detalle.setPrecioUnitario(detalleActualizado.getPrecioUnitario());
        }
        if (detalleActualizado.getSubtotal() > 0) {
            detalle.setSubtotal(detalleActualizado.getSubtotal());
        }
        if (detalleActualizado.getVenta() != null && !detalleActualizado.getVenta().isEmpty()) {
            detalle.setVenta(detalleActualizado.getVenta());
        }

        return detalleVentaRepository.save(detalle);
    }

    @Override
    public void deleteById(Long id) {
        if (!detalleVentaRepository.existsById(id)) {
            throw new IllegalArgumentException("Detalle de venta no encontrado");
        }
        detalleVentaRepository.deleteById(id);
    }
	
}
