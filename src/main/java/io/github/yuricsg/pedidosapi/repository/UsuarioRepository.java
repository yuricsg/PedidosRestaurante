package io.github.yuricsg.pedidosapi.repository;

import io.github.yuricsg.pedidosapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Usuario findByLogin(String login);
}
