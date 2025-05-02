package com.comercioonline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comercioonline.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
