package io.github.sebgh0.andes_fin.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoSimulacionDTO {

    @NotBlank
    private String nombre;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal precio;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal porcentajeGanancia;

}
