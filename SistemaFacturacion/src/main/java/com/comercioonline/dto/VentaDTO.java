package com.comercioonline.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class VentaDTO {
	private Long id;
    private LocalDateTime createdAt;
    private String cliente;
    private int total;
    private String detalleVenta;
}
