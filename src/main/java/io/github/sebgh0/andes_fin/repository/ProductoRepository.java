package io.github.sebgh0.andes_fin.repository;

import io.github.sebgh0.andes_fin.entity.ProductoFinanciero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductoRepository extends JpaRepository<ProductoFinanciero, UUID> {
}
