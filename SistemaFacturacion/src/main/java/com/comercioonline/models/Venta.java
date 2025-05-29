package com.comercioonline.models;

import java.time.LocalDateTime;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "ventas")
@Schema(description = "Modelo que representa una venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID de la venta", example = "1")
    private Long id;

    @Column(name = "fecha", nullable = false)
    @Schema(description = "Fecha y hora en que se realizó la venta", example = "2025-05-27T14:30:00")
    private LocalDateTime createdAt;

    @Column(name = "cliente", nullable = false)
    @Schema(description = "Nombre del cliente asociado a la venta", example = "Juan Pérez")
    private String cliente;

    @Column(name = "total", nullable = false)
    @Schema(description = "Total de la venta en centavos", example = "15000")
    private int total;

    // ✅ Relación con detalleVenta (uno a muchos)
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    @Schema(description = "Lista de detalles de esta venta")
    private List<DetalleVenta> detallesVenta;

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
}
