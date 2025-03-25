package io.github.yuricsg.pedidosapi.controller;

import io.github.yuricsg.pedidosapi.dto.UsuarioDTO;
import io.github.yuricsg.pedidosapi.service.UsuarioService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    public void salvar(@RequestBody UsuarioDTO dto){

    }
}
