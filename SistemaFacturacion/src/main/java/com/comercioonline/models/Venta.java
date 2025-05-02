package com.comercioonline.models;

import java.time.LocalDateTime;
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
@Table(name = "Ventas")
public class Venta {

	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Valor autoincremental.
	private Long id;
	
	@Column(name = "Fecha", nullable = false)
	private LocalDateTime createdAt;
	@Column(name = "Cliente", nullable = false)
	private String cliente;
	@Column(name = "Total", nullable = false)
	private int total;
	@Column(name = "Detalle de la venta", nullable = false)
	private String detalleVenta;
}
