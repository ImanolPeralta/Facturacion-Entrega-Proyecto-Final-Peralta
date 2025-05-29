package com.comercioonline.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "Productos")
@Schema(description = "Modelo que representa un producto")
public class Producto {

	@Schema(description = "ID del producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Valor autoincremental.
	private Long id;
	
	@Schema(description = "Nombre del producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "Teclado mecánico")
	@Column(name = "Nombre", nullable = false, unique = true)
	private String nombre;
	
	@Schema(description = "Precio del producto en centavos", requiredMode = Schema.RequiredMode.REQUIRED, example = "2500")
	@Column(name = "Precio", nullable = false)
	private int precio;
	
	@Schema(description = "Descripción del producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "Teclado mecánico retroiluminado")
	@Column(name = "Descripción", nullable = false)
	private String descripcion;
	
	@Schema(description = "Cantidad en stock disponible", requiredMode = Schema.RequiredMode.REQUIRED, example = "15")
	@Column(name = "Stock", nullable = false)
	private int stock;
}
