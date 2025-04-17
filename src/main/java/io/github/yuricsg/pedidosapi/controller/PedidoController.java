package io.github.yuricsg.pedidosapi.controller;

import io.github.yuricsg.pedidosapi.dto.PedidoDTO;
import io.github.yuricsg.pedidosapi.model.Pedido;
import io.github.yuricsg.pedidosapi.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('CLIENTE', 'GERENTE')")
    public ResponseEntity<Pedido> criarPedido(@RequestBody @Valid PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoService.salvarPedido(pedidoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('CLIENTE', 'GERENTE')")
    public ResponseEntity<Pedido> obterPedido(@PathVariable Long id) {
        Pedido pedido = pedidoService.buscarPedido(id);
        return ResponseEntity.ok(pedido);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('CLIENTE', 'GERENTE')")
    public ResponseEntity<Pedido> atualizarPedido(@PathVariable Long id, @RequestBody @Valid PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoService.atualizarPedido(id, pedidoDTO);
        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('CLIENTE', 'GERENTE')")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
        pedidoService.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }
}
