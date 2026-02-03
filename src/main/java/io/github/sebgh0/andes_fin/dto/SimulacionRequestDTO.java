package io.github.sebgh0.andes_fin.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SimulacionRequestDTO {

    @NotNull
    private UUID usuarioId;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal capitalDisponible;

    @NotEmpty
    private List<ProductoSimulacionDTO> productos;

}
