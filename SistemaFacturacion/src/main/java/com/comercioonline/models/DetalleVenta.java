package com.comercioonline.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Detalle de la Venta")
public class DetalleVenta {

	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Valor autoincremental.
	private Long id;
	
	@Column(name = "Producto", nullable = false)
	private String producto;
	@Column(name = "Cantidad", nullable = false)
	private int cantidad;
	@Column(name = "Precio Unitario", nullable = false)
	private int precioUnitario;
	@Column(name = "Subtotal", nullable = false)
	private int subtotal;
	@Column(name = "Venta", nullable = false)
	private String venta;
}
