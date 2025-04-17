package io.github.yuricsg.pedidosapi.service;

import io.github.yuricsg.pedidosapi.model.Client;
import io.github.yuricsg.pedidosapi.repository.ClientRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository repository;
    private final PasswordEncoder encoder;

    public ClientService(ClientRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public Client salvar(Client client){
        var senhaCriptografada = encoder.encode(client.getClientSecret());
        client.setClientSecret(senhaCriptografada);
        return repository.save(client);
    }

    public Client obterPorClientID(String clientId){
        return repository.findByClientId(clientId);
    }
}
