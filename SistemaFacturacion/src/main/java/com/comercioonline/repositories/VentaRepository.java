package com.comercioonline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comercioonline.models.Venta;


public interface VentaRepository extends JpaRepository<Venta, Long> {

}
