package com.comercioonline.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.JoinColumn;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "Productos")
public class Producto {

	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Valor autoincremental.
	private Long id;
	
	@Column(name = "Nombre", nullable = false, unique = true)
	private String nombre;
	@Column(name = "Precio", nullable = false)
	private int precio;
	@Column(name = "Descripción", nullable = false)
	private String descripcion;
	@Column(name = "Stock", nullable = false)
	private int stock;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
				name = "cliente_producto",
				joinColumns = @JoinColumn(name = "producto_id"),
				inverseJoinColumns = @JoinColumn(name = "cliente_id")
			)
	private List<Cliente> clientes = new ArrayList<>();
}
