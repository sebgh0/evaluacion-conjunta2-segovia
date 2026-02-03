package io.github.sebgh0.andes_fin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name ="usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(length = 30, nullable = false)
    private  String nombre;

    @Column(unique = true, length = 50, nullable = false)
    private  String email;

    @Column(precision = 10, scale = 2)
    private BigDecimal capital_disponible;
}
