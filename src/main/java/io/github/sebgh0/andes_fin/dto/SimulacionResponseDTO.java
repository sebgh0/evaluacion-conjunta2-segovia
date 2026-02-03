package io.github.sebgh0.andes_fin.dto;

import io.github.sebgh0.andes_fin.entity.ProductoFinanciero;
import io.github.sebgh0.andes_fin.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SimulacionResponseDTO {


    private UUID id;
    private UUID usuarioId;
    private LocalDateTime fechaSimulacion;

    private BigDecimal capitalDisponible;
    private BigDecimal costoTotal;
    private BigDecimal capitalRestante;
    private BigDecimal gananciaTotal;
    private BigDecimal retornoTotalPorcentaje;

    private List<ProductoResultadoDTO> productosSeleccionados;
    private String mensaje;
}
