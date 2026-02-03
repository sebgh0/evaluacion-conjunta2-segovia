package io.github.sebgh0.andes_fin.service.impl;

import io.github.sebgh0.andes_fin.dto.ProductoDTO;
import io.github.sebgh0.andes_fin.repository.ProductoRepository;
import io.github.sebgh0.andes_fin.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository repo;

    @Override
    public List<ProductoDTO> getAll() {
        return repo.findByActivoTrue().stream()
                .map(p -> ProductoDTO.builder()
                        .id(p.getId())
                        .nombre(p.getNombre())
                        .descripcion(p.getDescripcion())
                        .costo(p.getCosto())
                        .porcentajeRetorno(p.getPorcentajeRetorno())
                        .activo(p.isActivo())
                        .build())
                .toList();
    }

}
