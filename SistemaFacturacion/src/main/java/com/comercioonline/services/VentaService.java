package com.comercioonline.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercioonline.dto.ComprobanteRequestDTO;
import com.comercioonline.interfaces.CrudInterface;
import com.comercioonline.models.Cliente;
import com.comercioonline.models.DetalleVenta;
import com.comercioonline.models.Producto;
import com.comercioonline.models.Venta;
import com.comercioonline.repositories.ClienteRepository;
import com.comercioonline.repositories.ProductoRepository;
import com.comercioonline.repositories.VentaRepository;

import jakarta.transaction.Transactional;

@Service
public class VentaService implements CrudInterface<Venta, Long> {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

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
        Venta venta = ventaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Venta no encontrada"));

        if (ventaActualizada.getCreatedAt() != null) {
            venta.setCreatedAt(ventaActualizada.getCreatedAt());
        }
        if (ventaActualizada.getCliente() != null && !ventaActualizada.getCliente().isEmpty()) {
            venta.setCliente(ventaActualizada.getCliente());
        }
        if (ventaActualizada.getTotal() > 0) {
            venta.setTotal(ventaActualizada.getTotal());
        }
        if (ventaActualizada.getDetallesVenta() != null && !ventaActualizada.getDetallesVenta().isEmpty()) {
            venta.setDetallesVenta(ventaActualizada.getDetallesVenta());
        }

        return ventaRepository.save(venta);
    }

    @Override
    public void deleteById(Long id) {
        if (!ventaRepository.existsById(id)) {
            throw new IllegalArgumentException("Venta no encontrada");
        }

        ventaRepository.deleteById(id);
    }
    
    @Transactional
    public Venta crearVentaDesdeComprobante(ComprobanteRequestDTO request) {
        // Buscar cliente
    	Cliente cliente = clienteRepository.findById(request.getClienteId())
    	        .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
        // Crear nueva venta
        Venta venta = new Venta();
        venta.setCliente(cliente.getNombre());
        venta.setCreatedAt(LocalDateTime.now());

        List<DetalleVenta> detalles = new ArrayList<>();
        int total = 0;

        // Iterar sobre productos del comprobante
        for (var linea : request.getProductos()) {
            Producto producto = productoRepository.findById(linea.getProductoid())
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

            if (producto.getStock() < linea.getCantidad()) {
                throw new IllegalArgumentException("Stock insuficiente para producto: " + producto.getNombre());
            }

            int subtotal = producto.getPrecio() * linea.getCantidad();
            total += subtotal;

            DetalleVenta detalle = new DetalleVenta();
            detalle.setVenta(venta); // Relación bidireccional
            detalle.setProducto(producto.getNombre());
            detalle.setCantidad(linea.getCantidad());
            detalle.setPrecioUnitario(producto.getPrecio());
            detalle.setSubtotal(subtotal);

            detalles.add(detalle);

            // Actualizar stock del producto
            producto.setStock(producto.getStock() - linea.getCantidad());
            productoRepository.save(producto);
        }

        venta.setTotal(total);
        venta.setDetallesVenta(detalles); // Relaciona los detalles a la venta

        return ventaRepository.save(venta); // Cascade.ALL guarda también los detalles
    }



}