package com.comercioonline.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@Table(name = "Clientes")
public class Cliente {

	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Valor autoincremental.
	private Long id;
	
	@Column(name = "Nombre", nullable = false)
	private String nombre;
	@Column(name = "Apellido", nullable = false)
	private String apellido;
	@Column(name = "Domicilio", nullable = false)
	private String domicilio;
	@Column(name = "Código Postal", nullable = false)
	private int codigoPostal;
	@Column(name = "Correo Electrónico", nullable = false, unique = true)
	private String email;
	@Column(name = "DNI", nullable = false, unique = true)
	private int dni;
	@Column(name = "Número de Teléfono", nullable = false, unique = true)
	private long telefono;
	
	@ManyToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
	private List<Producto> productos = new ArrayList<>();
	
	private LocalDateTime createdAt;

	
	
	
	
}

