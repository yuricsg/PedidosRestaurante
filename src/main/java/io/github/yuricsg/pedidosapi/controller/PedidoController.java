package io.github.yuricsg.pedidosapi.controller;

import io.github.yuricsg.pedidosapi.dto.PedidoDTO;
import io.github.yuricsg.pedidosapi.model.Pedido;
import io.github.yuricsg.pedidosapi.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoService.salvarPedido(pedidoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> obterPedido(@PathVariable Long id) {
        Pedido pedido = pedidoService.buscarPedido(id);
        return ResponseEntity.ok(pedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizarPedido(@PathVariable Long id, @RequestBody PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoService.atualizarPedido(id, pedidoDTO);
        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
        pedidoService.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }
}
