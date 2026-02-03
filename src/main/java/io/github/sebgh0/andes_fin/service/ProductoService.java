package io.github.sebgh0.andes_fin.service;

import io.github.sebgh0.andes_fin.dto.CreateProductoDTO;
import io.github.sebgh0.andes_fin.dto.ProductoDTO;

import java.util.List;

public interface ProductoService {

    List<ProductoDTO> getAll();

    ProductoDTO getById();

    ProductoDTO create(CreateProductoDTO dto);
}
