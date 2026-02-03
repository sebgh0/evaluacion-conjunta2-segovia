package io.github.sebgh0.andes_fin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "simulacion_producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimulacionProducto {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "simulacion_id")
    private Simulacion simulacion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "producto_id")
    private ProductoFinanciero producto;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal costo;

    @Column(precision = 5, scale = 2, nullable = false)
    private BigDecimal porcentajeRetorno;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal gananciaCalculada;
}
