package io.github.yuricsg.pedidosapi.service;

import io.github.yuricsg.pedidosapi.dto.ClienteDTO;
import io.github.yuricsg.pedidosapi.model.Cliente;
import io.github.yuricsg.pedidosapi.repository.ClienteRepository;
import io.github.yuricsg.pedidosapi.validator.ClienteValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    private final ClienteValidator validator;

    public ClienteService(ClienteValidator validator) {
        this.validator = validator;
    }

    public Cliente salvarCliente(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.nome());
        cliente.setEmail(dto.email());
        validator.validar(cliente);
        return clienteRepository.save(cliente);
    }

    public Cliente buscarCliente(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Cliente atualizarCliente(Long id, ClienteDTO dto) {
        Cliente cliente = buscarCliente(id);
        cliente.setNome(dto.nome());
        cliente.setEmail(dto.email());
        validator.validar(cliente);
        return clienteRepository.save(cliente);
    }

    public void deletarCliente(Long id) {
        Cliente cliente = buscarCliente(id);
        clienteRepository.delete(cliente);
    }

}
