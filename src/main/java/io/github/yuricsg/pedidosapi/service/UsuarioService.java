package io.github.yuricsg.pedidosapi.service;

import io.github.yuricsg.pedidosapi.model.Usuario;
import io.github.yuricsg.pedidosapi.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;

    public UsuarioService(UsuarioRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public void salvar(Usuario usuario){
        var senha = usuario.getPassword();
        usuario.setPassword(encoder.encode(senha));
        repository.save(usuario);
    }

    public Usuario obterPorUsername(String username){
        return repository.findByLogin(username);
    }
}
