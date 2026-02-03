package io.github.sebgh0.andes_fin.repository;

import io.github.sebgh0.andes_fin.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    boolean existsByEmail(String email);
}
