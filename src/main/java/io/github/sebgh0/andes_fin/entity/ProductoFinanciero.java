package io.github.sebgh0.andes_fin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "productos_financiero")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductoFinanciero {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(length = 30, nullable = false)
    private String nombre;

    @Column(length = 50, nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @Column(precision = 10, scale = 2)
    private BigDecimal costo;

    @Column(precision = 5, scale = 2)
    private BigDecimal porcentaje_retorno;

    @Column(nullable = false)
    private  boolean activo;



}
