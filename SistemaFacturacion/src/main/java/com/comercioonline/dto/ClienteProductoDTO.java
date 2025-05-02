package com.comercioonline.dto;

import java.util.List;

import lombok.Data;

@Data
public class ClienteProductoDTO {
	private Long clienteId;
    private List<Long> productoIds;
}