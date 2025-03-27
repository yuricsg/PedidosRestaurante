package io.github.yuricsg.pedidosapi.controller;

import io.github.yuricsg.pedidosapi.dto.UsuarioDTO;
import io.github.yuricsg.pedidosapi.model.Usuario;
import io.github.yuricsg.pedidosapi.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody UsuarioDTO dto){
        Usuario usuario = new Usuario();
        usuario.setLogin(dto.login());
        usuario.setSenha(dto.senha());
        usuario.setRoles(dto.roles());

        service.salvar(usuario);
    }
}
