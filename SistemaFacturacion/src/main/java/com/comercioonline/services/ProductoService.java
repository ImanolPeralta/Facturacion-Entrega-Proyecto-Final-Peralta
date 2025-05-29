package com.comercioonline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercioonline.interfaces.CrudInterface;
import com.comercioonline.models.Producto;
import com.comercioonline.repositories.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductoService implements CrudInterface<Producto, Long> {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Producto findById(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
    }

    @Override
    @Transactional
    public Producto save(Producto nuevoProducto) {
        return productoRepository.save(nuevoProducto);
    }

    @Override
    @Transactional
    public Producto update(Long id, Producto productoActualizado) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        if (productoActualizado.getNombre() != null && !productoActualizado.getNombre().isEmpty()) {
            producto.setNombre(productoActualizado.getNombre());
        }
        if (productoActualizado.getDescripcion() != null && !productoActualizado.getDescripcion().isEmpty()) {
            producto.setDescripcion(productoActualizado.getDescripcion());
        }
        if (productoActualizado.getPrecio() > 0) {
            producto.setPrecio(productoActualizado.getPrecio());
        }
        if (productoActualizado.getStock() >= 0) {
            producto.setStock(productoActualizado.getStock());
        }

        return productoRepository.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        if (!productoRepository.existsById(id)) {
            throw new IllegalArgumentException("Producto no encontrado");
        }
        productoRepository.deleteById(id);
    }
    
    // Este Script es el que actualiza todos los precios de los productos en general si existe un porcentaje de inflación.
    @Transactional
    public List<Producto> actualizarPreciosPorInflacion(double porcentajeInflacion) {
        List<Producto> productos = productoRepository.findAll();

        for (Producto producto : productos) {
            int precioActual = producto.getPrecio();
            int nuevoPrecio = (int) Math.round(precioActual * (1 + porcentajeInflacion / 100.0));
            producto.setPrecio(nuevoPrecio);
        }

        return productoRepository.saveAll(productos); // Guarda todos los productos actualizados
    }

}
