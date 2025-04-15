package com.comercioonline.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
	
	public DetalleVenta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetalleVenta(String producto, int cantidad, int precioUnitario, int subtotal, String venta) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.subtotal = subtotal;
		this.venta = venta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(int precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public String getVenta() {
		return venta;
	}

	public void setVenta(String venta) {
		this.venta = venta;
	}

	@Override
	public String toString() {
		return "DetalleVenta [id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + ", precioUnitario="
				+ precioUnitario + ", subtotal=" + subtotal + ", venta=" + venta + "]";
	}
	
	
	
}
