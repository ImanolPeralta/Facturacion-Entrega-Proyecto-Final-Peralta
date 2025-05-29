package com.comercioonline.dto;

import lombok.Data;
import java.util.List;

@Data
public class ComprobanteRequestDTO {
    private Long clienteId; // ID del cliente que realiza la compra
    private List<LineaVentaDTO> productos; // Lista de productos con sus cantidades
}
