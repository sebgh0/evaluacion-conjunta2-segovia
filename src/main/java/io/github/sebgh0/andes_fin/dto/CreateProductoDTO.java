package io.github.sebgh0.andes_fin.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductoDTO {

    @NotBlank
    @Size(min=1, max=30)
    private String nombre;


    private String descripcion;
    private BigDecimal costo;
    private BigDecimal porcentaje_retorno;
    private  boolean activo;
}
