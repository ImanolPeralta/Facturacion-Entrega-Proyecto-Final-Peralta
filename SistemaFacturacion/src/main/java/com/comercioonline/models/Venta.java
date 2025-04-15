package com.comercioonline.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
	
	public Venta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Venta(LocalDateTime createdAt, String cliente, int total, String detalleVenta) {
		super();
		this.createdAt = createdAt;
		this.cliente = cliente;
		this.total = total;
		this.detalleVenta = detalleVenta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getDetalleVenta() {
		return detalleVenta;
	}

	public void setDetalleVenta(String detalleVenta) {
		this.detalleVenta = detalleVenta;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", createdAt=" + createdAt + ", cliente=" + cliente + ", total=" + total
				+ ", detalleVenta=" + detalleVenta + "]";
	}
	
	
	
}
