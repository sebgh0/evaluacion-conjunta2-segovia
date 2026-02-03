package io.github.sebgh0.andes_fin.repository;

import io.github.sebgh0.andes_fin.entity.Simulacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SimulacionRepository extends JpaRepository<Simulacion, UUID> {
}
