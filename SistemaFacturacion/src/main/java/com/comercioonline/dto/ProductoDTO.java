package com.comercioonline.dto;

import lombok.Data;

@Data
public class ProductoDTO {
	private Long id;
    private String nombre;
    private String descripcion;
    private int precio;
    private int stock;
}
