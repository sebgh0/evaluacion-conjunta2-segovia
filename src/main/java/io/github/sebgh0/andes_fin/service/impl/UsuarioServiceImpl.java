package io.github.sebgh0.andes_fin.service.impl;

import io.github.sebgh0.andes_fin.dto.CreateUsuarioDTO;
import io.github.sebgh0.andes_fin.dto.UsuarioDTO;
import io.github.sebgh0.andes_fin.entity.Usuario;
import io.github.sebgh0.andes_fin.repository.UsuarioRepository;
import io.github.sebgh0.andes_fin.service.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repo;

    @Override
    public List<UsuarioDTO> getAll(){

        return repo.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());

    }

    @Override
    public UsuarioDTO getById(UUID id){
        Usuario usuario = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Autor no encontrado con id: " + id));
        return mapToResponse(usuario);
    }

    @Override
    public  UsuarioDTO create(CreateUsuarioDTO dto){

        if (repo.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Ya existe un usuarios con el email: " + dto.getEmail());
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setEmail(dto.getEmail());
        usuario.setCapital_disponible(dto.getCapital_disponible());

        Usuario saved = repo.save(usuario);

        return mapToResponse(saved);
    }


    private UsuarioDTO mapToResponse(Usuario usuario){
        return UsuarioDTO.builder()
                .id(usuario.getId())
                .nombre(usuario.getNombre())
                .email(usuario.getEmail())
                .capital_disponible(usuario.getCapital_disponible())
                .build();
    }


}
