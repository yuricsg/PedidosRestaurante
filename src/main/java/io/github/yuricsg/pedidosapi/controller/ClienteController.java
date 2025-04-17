package io.github.yuricsg.pedidosapi.controller;

import io.github.yuricsg.pedidosapi.dto.ClienteDTO;
import io.github.yuricsg.pedidosapi.dto.ErroResposta;
import io.github.yuricsg.pedidosapi.exceptions.RegistroDuplicadoException;
import io.github.yuricsg.pedidosapi.model.Cliente;
import io.github.yuricsg.pedidosapi.service.ClienteService;
import io.github.yuricsg.pedidosapi.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    @PreAuthorize("hasRole('GERENTE')")
    public ResponseEntity<Object> criarCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
        try {
            Cliente cliente = clienteService.salvarCliente(clienteDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
        }catch(RegistroDuplicadoException e){
            var erroDTO = ErroResposta.conflito(e.getMessage());
            return ResponseEntity.status(erroDTO.status()).body(erroDTO);
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('CLIENTE', 'GERENTE')")
    public ResponseEntity<Cliente> obterCliente(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarCliente(id);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('CLIENTE', 'GERENTE')")
    public ResponseEntity<Object> atualizarCliente(@PathVariable Long id, @RequestBody @Valid ClienteDTO clienteDTO) {
        try {
            Cliente cliente = clienteService.atualizarCliente(id, clienteDTO);
            return ResponseEntity.ok(cliente);
        }catch (RegistroDuplicadoException e){
            var erroDTO = ErroResposta.conflito(e.getMessage());
            return ResponseEntity.status(erroDTO.status()).body(erroDTO);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('CLIENTE', 'GERENTE')")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
