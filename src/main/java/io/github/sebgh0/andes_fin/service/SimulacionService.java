package io.github.sebgh0.andes_fin.service;

import io.github.sebgh0.andes_fin.dto.SimulacionRequestDTO;
import io.github.sebgh0.andes_fin.dto.SimulacionResponseDTO;
import io.github.sebgh0.andes_fin.entity.Simulacion;

import java.util.List;
import java.util.UUID;

public interface SimulacionService {

    SimulacionResponseDTO simular(SimulacionRequestDTO dto);

    List<Simulacion> listarPorUsuario(UUID usuarioId);
}
