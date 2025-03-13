package io.github.yuricsg.pedidosapi.repository;

import io.github.yuricsg.pedidosapi.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PedidosRepository extends JpaRepository<Pedido, UUID> {
}
