package io.github.sebgh0.andes_fin.dto;

import io.github.sebgh0.andes_fin.entity.ProductoFinanciero;
import io.github.sebgh0.andes_fin.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimulacionResponseDTO {


    private UUID id;

    private Usuario usuario;


    private LocalDate fecha_simulacion;


    private BigDecimal capital_disponible;


    private  BigDecimal ganancia_total;


    private List<ProductoFinanciero> producto;
}
