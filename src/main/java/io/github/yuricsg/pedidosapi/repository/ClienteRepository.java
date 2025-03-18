package io.github.yuricsg.pedidosapi.repository;

import io.github.yuricsg.pedidosapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByNomeAndEmail(
            String nome, String email
    );
}
