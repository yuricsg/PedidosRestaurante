package io.github.yuricsg.pedidosapi.repository;

import io.github.yuricsg.pedidosapi.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByClientId(String clientId);
}
