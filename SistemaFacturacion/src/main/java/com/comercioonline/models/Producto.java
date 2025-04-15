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
import jakarta.persistence.JoinColumn;

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
	private List<Cliente> cliente = new ArrayList<>();
	
	public Producto(String string) {
		super();
		// TODO Auto-generated constructor stub
	}
	public Producto(String nombre, int precio, String descripcion, int stock) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.stock = stock;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descripcion=" + descripcion
				+ ", stock=" + stock + "]";
	}
	
	
	
}
