package io.github.sebgh0.andes_fin.service.impl;

import io.github.sebgh0.andes_fin.dto.ProductoResultadoDTO;
import io.github.sebgh0.andes_fin.dto.ProductoSimulacionDTO;
import io.github.sebgh0.andes_fin.dto.SimulacionRequestDTO;
import io.github.sebgh0.andes_fin.dto.SimulacionResponseDTO;
import io.github.sebgh0.andes_fin.entity.Simulacion;
import io.github.sebgh0.andes_fin.entity.Usuario;
import io.github.sebgh0.andes_fin.repository.ProductoRepository;
import io.github.sebgh0.andes_fin.repository.SimulacionRepository;
import io.github.sebgh0.andes_fin.repository.UsuarioRepository;
import io.github.sebgh0.andes_fin.service.SimulacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SimulacionServiceImpl implements SimulacionService {

    private UsuarioRepository usuarioRepository;
    private ProductoRepository productoRepository;
    private SimulacionRepository simulacionRepository;

    @Override
    public SimulacionResponseDTO simular(SimulacionRequestDTO dto) {

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // 1️⃣ Filtrar productos viables
        List<ProductoSimulacionDTO> viables = dto.getProductos().stream()
                .filter(p -> p.getPrecio().compareTo(dto.getCapitalDisponible()) <= 0)
                .toList();

        if (viables.isEmpty()) {
            throw new RuntimeException("Fondos insuficientes");
        }

        // 2️⃣ Ordenar por ganancia DESC (heurística válida)
        viables = viables.stream()
                .sorted((a, b) -> calcularGanancia(b).compareTo(calcularGanancia(a)))
                .toList();

        BigDecimal capitalRestante = dto.getCapitalDisponible();
        BigDecimal gananciaTotal = BigDecimal.ZERO;
        BigDecimal costoTotal = BigDecimal.ZERO;

        List<ProductoResultadoDTO> seleccionados = new ArrayList<>();

        // 3️⃣ Selección greedy
        for (ProductoSimulacionDTO p : viables) {
            if (p.getPrecio().compareTo(capitalRestante) <= 0) {
                BigDecimal ganancia = calcularGanancia(p);
                capitalRestante = capitalRestante.subtract(p.getPrecio());
                gananciaTotal = gananciaTotal.add(ganancia);
                costoTotal = costoTotal.add(p.getPrecio());

                seleccionados.add(
                        ProductoResultadoDTO.builder()
                                .nombre(p.getNombre())
                                .precio(p.getPrecio())
                                .porcentajeGanancia(p.getPorcentajeGanancia())
                                .gananciaEsperada(ganancia)
                                .build()
                );
            }
        }

        // 4️⃣ Guardar simulación
        Simulacion simulacion = new Simulacion();
        simulacion.setUsuario(usuario);
        simulacion.setCapitalDisponible(dto.getCapitalDisponible());
        simulacion.setGananciaTotal(gananciaTotal);

        simulacionRepository.save(simulacion);

        // 5️⃣ Retorno %
        BigDecimal retorno = gananciaTotal
                .multiply(BigDecimal.valueOf(100))
                .divide(costoTotal, 2, RoundingMode.HALF_UP);

        return SimulacionResponseDTO.builder()
                .id(simulacion.getId())
                .usuarioId(usuario.getId())
                .fechaSimulacion(simulacion.getFechaSimulacion())
                .capitalDisponible(dto.getCapitalDisponible())
                .costoTotal(costoTotal)
                .capitalRestante(capitalRestante)
                .gananciaTotal(gananciaTotal)
                .retornoTotalPorcentaje(retorno)
                .productosSeleccionados(seleccionados)
                .mensaje("Simulación exitosa")
                .build();
    }


    private BigDecimal calcularGanancia(ProductoSimulacionDTO p) {
        return p.getPrecio()
                .multiply(p.getPorcentajeGanancia())
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }

    @Override
    public List<Simulacion> listarPorUsuario(UUID usuarioId) {
        return simulacionRepository.findByUsuarioId(usuarioId);
    }
}
