package io.github.sebgh0.andes_fin.dto;

import jakarta.validation.constraints.*;
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
public class UsuarioDTO {

    private UUID id;

    private  String nombre;
    private  String email;
    private BigDecimal capitalDisponible;
}
