package io.github.yuricsg.pedidosapi.validator;

import io.github.yuricsg.pedidosapi.exceptions.RegistroDuplicadoException;
import io.github.yuricsg.pedidosapi.model.Cliente;
import io.github.yuricsg.pedidosapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClienteValidator {

    private ClienteRepository repository;

    public ClienteValidator(ClienteRepository repository) {
        this.repository = repository;
    }

    public void validar(Cliente cliente){
        if(existeClienteCadastrado(cliente)){
            throw new RegistroDuplicadoException("Cliente já cadastrado!");
        }
    }

    private boolean existeClienteCadastrado(Cliente cliente){
        Optional<Cliente> clienteEncontrado = repository.findByNomeAndEmail(
                cliente.getNome(), cliente.getEmail()
        );

        if(cliente.getId() == null){
            return clienteEncontrado.isPresent();
        }

        return cliente.getId().equals(clienteEncontrado.get().getId()) && clienteEncontrado.isPresent();
    }

}
