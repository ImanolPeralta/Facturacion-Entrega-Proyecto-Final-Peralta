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
	private List<Producto> producto = new ArrayList<>();
	
	private LocalDateTime createdAt;

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(String nombre, String apellido, String domicilio, int codigoPostal, String email, int dni,
			long telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.codigoPostal = codigoPostal;
		this.email = email;
		this.dni = dni;
		this.telefono = telefono;
		
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", domicilio=" + domicilio
				+ ", codigoPostal=" + codigoPostal + ", email=" + email + ", dni=" + dni + ", telefono=" + telefono
				+ ", createdAt=" + createdAt + "]";
	}
	
	
	
}

