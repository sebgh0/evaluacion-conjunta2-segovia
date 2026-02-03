package io.github.sebgh0.andes_fin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "simulaciones")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Simulacion {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name ="usuario_id", nullable = false)
    private Usuario usuario;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaSimulacion;

    @Column(precision = 10, scale = 2)
    private BigDecimal capitalDisponible;

    @Column(precision = 10, scale = 2)
    private  BigDecimal gananciaTotal;

    @OneToMany(mappedBy = "simulacion", cascade = CascadeType.ALL)
    private List<SimulacionProducto> productosSeleccionados;


}
