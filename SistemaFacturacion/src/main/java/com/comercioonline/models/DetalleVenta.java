package com.comercioonline.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "detalle_venta")
@Schema(description = "Modelo que representa el detalle de una venta")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID del detalle de venta", example = "1")
    private Long id;

    @Column(nullable = false)
    @Schema(description = "Nombre del producto", example = "Mouse inalámbrico")
    private String producto;

    @Column(nullable = false)
    @Schema(description = "Cantidad del producto vendida", example = "3")
    private int cantidad;

    @Column(nullable = false)
    @Schema(description = "Precio unitario del producto", example = "1500")
    private int precioUnitario;

    @Column(nullable = false)
    @Schema(description = "Subtotal (cantidad * precio unitario)", example = "4500")
    private int subtotal;

    // ✅ Relación real con Venta
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venta_id", nullable = false)
    @ToString.Exclude
    @Schema(description = "Venta asociada a este detalle", hidden = true)
    private Venta venta;
}
