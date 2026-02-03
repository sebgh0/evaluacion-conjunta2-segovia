package io.github.sebgh0.andes_fin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoResultadoDTO {

    private String nombre;
    private BigDecimal precio;
    private BigDecimal porcentajeGanancia;
    private BigDecimal gananciaEsperada;
}
