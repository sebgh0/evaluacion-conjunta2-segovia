package io.github.sebgh0.andes_fin.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUsuarioDTO {

    @NotNull
    @NotBlank
    @Size(min = 1, max = 30)
    private  String nombre;

    @Email
    @NotBlank
    @Size(min = 1, max = 50)
    private  String email;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal capitalDisponible;
}
