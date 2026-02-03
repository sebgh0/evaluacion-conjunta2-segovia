package io.github.sebgh0.andes_fin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {

    private UUID id;

    private String nombre;
    private String descripcion;
    private BigDecimal costo;
    private BigDecimal porcentaje_retorno;
    private  boolean activo;

}
