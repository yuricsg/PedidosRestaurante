package io.github.yuricsg.pedidosapi.repository;

import io.github.yuricsg.pedidosapi.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PedidosRepository extends JpaRepository<Pedido, Long> {
}
