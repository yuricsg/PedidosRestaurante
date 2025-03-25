package io.github.yuricsg.pedidosapi.controller;

import io.github.yuricsg.pedidosapi.controller.mappers.ClienteMapper;
import io.github.yuricsg.pedidosapi.dto.ClienteDTO;
import io.github.yuricsg.pedidosapi.dto.ErroResposta;
import io.github.yuricsg.pedidosapi.exceptions.RegistroDuplicadoException;
import io.github.yuricsg.pedidosapi.model.Cliente;
import io.github.yuricsg.pedidosapi.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteMapper mapper;

    @PostMapping
    public ResponseEntity<Object> criarCliente(@RequestBody @Valid ClienteDTO dto) {
        try {
            Cliente cliente = mapper.toEntity(dto);
            Cliente clienteSalvo = clienteService.salvarCliente(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(clienteSalvo));
        } catch (RegistroDuplicadoException e) {
            var erroDTO = ErroResposta.conflito(e.getMessage());
            return ResponseEntity.status(erroDTO.status()).body(erroDTO);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obterCliente(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarCliente(id);
        if (cliente != null) {
            return ResponseEntity.ok(mapper.toDTO(cliente));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarCliente(@PathVariable Long id, @RequestBody @Valid ClienteDTO clienteDTO) {
        try {
            Cliente clienteAtualizado = clienteService.atualizarCliente(id, clienteDTO);
            return ResponseEntity.ok(mapper.toDTO(clienteAtualizado));
        } catch (RegistroDuplicadoException e) {
            var erroDTO = ErroResposta.conflito(e.getMessage());
            return ResponseEntity.status(erroDTO.status()).body(erroDTO);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
