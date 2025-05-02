package com.comercioonline.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.comercioonline.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
