package com.comercioonline.dto;

import lombok.Data;

@Data
public class LineaVentaDTO {
    private Long productoid; // ID del producto
    private int cantidad;    // Cantidad de ese producto en la venta
}
