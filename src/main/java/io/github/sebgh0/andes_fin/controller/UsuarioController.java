package io.github.sebgh0.andes_fin.controller;

import io.github.sebgh0.andes_fin.dto.CreateUsuarioDTO;
import io.github.sebgh0.andes_fin.dto.UsuarioDTO;
import io.github.sebgh0.andes_fin.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/")
    public List<UsuarioDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public  UsuarioDTO getById(@PathVariable  UUID id){
        return service.getById(id);
    }

    @PostMapping("/")
    public UsuarioDTO create(@Valid @RequestBody CreateUsuarioDTO dto){
        return  service.create(dto);
    }
}
