package com.comercioonline.dto;

import lombok.Data;

@Data
public class DetalleVentaDTO {
	private Long id;
    private String producto;
    private int cantidad;
    private int precioUnitario;
    private int subtotal;
    private String venta;
}
