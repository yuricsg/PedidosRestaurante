package io.github.yuricsg.pedidosapi.repository;

import io.github.yuricsg.pedidosapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
