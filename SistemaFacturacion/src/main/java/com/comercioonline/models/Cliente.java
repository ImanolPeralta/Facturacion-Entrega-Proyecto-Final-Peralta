package com.comercioonline.models;

import java.time.LocalDateTime;
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
@Schema(description = "Modelo de Cliente")
@Table(name = "Clientes")
public class Cliente {

	@Schema(description = "ID del Cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Valor autoincremental.
	private Long id;
	
	@Schema(description = "Nombre del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "Pedro")
	@Column(name = "Nombre", nullable = false)
	private String nombre;
	
	@Schema(description = "Apellido del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "González")
	@Column(name = "Apellido", nullable = false)
	private String apellido;
	
	@Schema(description = "Domicilio del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "25 De Mayo, 123")
	@Column(name = "Domicilio", nullable = false)
	private String domicilio;
	
	@Schema(description = "Código postal del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "5500")
	@Column(name = "Código Postal", nullable = false)
	private int codigoPostal;
	
	@Schema(description = "Correo electrónico del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "cliente@example.com")
	@Column(name = "Correo Electrónico", nullable = false, unique = true)
	private String email;
	
	@Schema(description = "DNI del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "12345678")
	@Column(name = "DNI", nullable = false, unique = true)
	private int dni;
	
	@Schema(description = "Número de teléfono del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "5491123456789")
	@Column(name = "Número de Teléfono", nullable = false, unique = true)
	private long telefono;
	
	@Schema(description = "Fecha y hora de creación del cliente", example = "2025-05-27T14:35:00")
	private LocalDateTime createdAt;

	
	
	
	
}

