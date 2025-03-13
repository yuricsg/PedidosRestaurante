package io.github.yuricsg.pedidosapi.repository;

import io.github.yuricsg.pedidosapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
}
